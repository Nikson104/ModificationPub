package pub.menu.search;

import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.RootMenuItem;
import pub.operations.SearchByRange;
import pub.util.RangeDate;

import java.time.LocalDate;

@MenuItemName(value = "Search by date production of beer", number = 4)
public class MenuSearchByDateProduction extends MenuSearchOperation implements Runnable {
    public MenuSearchByDateProduction(RootMenuItem rootMenu, Pub pub) {
        super(new SearchByRange(), rootMenu, pub);
    }

    @Override
    public void perform() {
        System.out.println("Enter a from date production of beer");
        String from = SCANNER.next();
        System.out.println("Enter a to date production of beer");
        String to = SCANNER.next();
        execute(new RangeDate(LocalDate.parse(from), LocalDate.parse(to)));
    }

    @Override
    public void run() {
        perform();
    }
}