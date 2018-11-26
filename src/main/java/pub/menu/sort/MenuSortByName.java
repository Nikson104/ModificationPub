package pub.menu.sort;

import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.RootMenuItem;
import pub.menu.MenuItemName;
import pub.operations.SortByName;

@MenuItemName(value = "Sort by name of beer", number = 0)
public class MenuSortByName extends MenuSortOperation implements Runnable {
    public MenuSortByName(RootMenuItem rootMenu, Pub pub) {
        super(new SortByName(), rootMenu, pub);
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