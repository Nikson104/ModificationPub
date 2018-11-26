package pub.menu.search;

import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.RootMenuItem;
import pub.operations.SearchByName;

@MenuItemName(value = "Search by name of beer", number = 2)
public class MenuSearchByName extends MenuSearchOperation implements Runnable {
    public MenuSearchByName(RootMenuItem rootMenu, Pub pub) {
        super(new SearchByName(), rootMenu, pub);
    }

    @Override
    public void perform() {
        System.out.println("Please input beer name:");
        String name = SCANNER.next();
        execute(name);
    }

    @Override
    public void run() {
        perform();
    }
}