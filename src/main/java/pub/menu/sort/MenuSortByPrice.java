package pub.menu.sort;

import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.RootMenuItem;
import pub.menu.MenuItemName;
import pub.operations.SortByPrice;

@MenuItemName(value = "Sort by price of beer", number = 1)
public class MenuSortByPrice extends MenuSortOperation implements Runnable {
    public MenuSortByPrice(RootMenuItem rootMenu, Pub pub) {
        super(new SortByPrice(), rootMenu, pub);
    }

    @Override
    public void perform() {
        execute();
    }

    @Override
    public void run() {
        perform();
    }
}