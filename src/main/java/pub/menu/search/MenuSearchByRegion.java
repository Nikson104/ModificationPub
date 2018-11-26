package pub.menu.search;

import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.RootMenuItem;
import pub.operations.SearchByRegion;

@MenuItemName(value = "Search by region", number = 5)
public class MenuSearchByRegion extends MenuSearchOperation implements Runnable {
    public MenuSearchByRegion(RootMenuItem rootMenu, Pub pub) {
        super(new SearchByRegion(), rootMenu, pub);
    }

    @Override
    public void perform() {
        System.out.println("Please input beer region:");
        String region = SCANNER.next();
        execute(region);
    }

    @Override
    public String toString() {
        return "MenuSearchByRegion" +
                "operation=" + operation;
    }

    @Override
    public void run() {
        perform();
    }
}