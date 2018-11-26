package pub.menu;

import org.reflections.Reflections;
import pub.menu.MenuCombineAction.MenuSortByNameAndPrice;
import pub.menu.search.*;
import pub.entity.Pub;
import pub.menu.sort.MenuSortByName;
import pub.menu.sort.MenuSortByPrice;

import java.util.*;
import java.util.stream.Collectors;

public class MenuDisplay implements RootMenuItem {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PACKAGE = "pub.menu";

    private List<Thread> subMenus = new ArrayList<>();

    public MenuDisplay(Pub pub) {
        subMenus.add(new Thread(new MenuSortByName(this, pub)));
        subMenus.add(new Thread(new MenuSortByPrice(this, pub)));
        subMenus.add(new Thread(new MenuSearchByName(this, pub)));
        subMenus.add(new Thread(new MenuSearchByPrice(this, pub)));
        subMenus.add(new Thread(new MenuSearchByDateProduction(this, pub)));
        subMenus.add(new Thread(new MenuSearchByRegion(this, pub)));
        subMenus.add(new Thread(new MenuInfoSimilarBeer(this, pub)));
        subMenus.add(new Thread(new MenuSortByNameAndPrice(this, pub)));
    }

    private void printMenuItem(PrintItem item) {
        System.out.println(item.toString());
    }

    @Override
    public void execute() {
        getMenu().forEach(this::printMenuItem);
        System.out.print("Choose a number of operation: ");

        subMenus.get(SCANNER.nextInt()).start();
    }

    public List<PrintItem> getMenu() {
        Reflections reflections = new Reflections(PACKAGE);
        Map<Integer, String> printItems = new TreeMap();

        List<Class<? extends MenuItem>> menuItems = new ArrayList<>(reflections.getSubTypesOf(MenuItem.class));

        return menuItems
                .stream()
                .filter(aClass -> aClass.getAnnotation(MenuItemName.class) != null)
                .map(aClass -> new MenuDisplay.PrintItem(
                        aClass.getAnnotation(MenuItemName.class).number(),
                        aClass.getAnnotation(MenuItemName.class).value())
                )
                .sorted((o1, o2) -> o1.number < o2.number ? -1 : 1)
                .collect(Collectors.toList());
    }

    class PrintItem {
        private final int number;
        private final String value;

        PrintItem(int number, String value) {
            this.number = number;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PrintItem printItem = (PrintItem) o;
            return number == printItem.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }

        @Override
        public String toString() {
            return number + ". " + value;
        }
    }
}