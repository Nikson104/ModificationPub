package pub.menu.search;


import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.RootMenuItem;
import pub.operations.SearchByRange;
import pub.util.RangePrice;

@MenuItemName(value = "Search by beer price", number = 3)
public class MenuSearchByPrice extends MenuSearchOperation implements Runnable {
    public MenuSearchByPrice(RootMenuItem rootMenu, Pub pub) {
        super(new SearchByRange(), rootMenu, pub);

    }

    @Override
    public void perform() {
        System.out.println("Please input beer price from:");
        int priceFrom = SCANNER.nextInt();
        System.out.println("Please input beer price to:");
        int priceTo = SCANNER.nextInt();
        execute(new RangePrice(priceFrom, priceTo));
    }

    @Override
    public void run() {
        perform();
    }
}
