package pub.menu.MenuCombineAction;

import pub.entity.Pub;
import pub.menu.MenuDisplay;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.search.MenuSearchByName;
import pub.menu.search.MenuSearchOperation;
import pub.menu.sort.MenuSortByName;
import pub.menu.sort.MenuSortByPrice;
import pub.menu.sort.MenuSortOperation;

@MenuItemName(value = "Combine action", number = 7)
public class MenuSortByNameAndPrice implements MenuItem, Runnable {
    private final MenuSortByName sortByName;
    private final MenuSortByPrice sortByPrice;

    public MenuSortByNameAndPrice(MenuDisplay menuDisplay, Pub pub) {
        this.sortByName = new MenuSortByName(menuDisplay, pub);
        this.sortByPrice = new MenuSortByPrice(menuDisplay, pub);
    }

    @Override
    public void run() {
        perform();
    }

    @Override
    public void perform() {
        new Thread(sortByName).start();
        new Thread(sortByPrice).start();

    }
}
