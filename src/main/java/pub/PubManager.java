package pub;

import pub.entity.Beer;
import pub.entity.Pub;
import pub.menu.MenuDisplay;
import pub.menu.RootMenuItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PubManager {
    private RootMenuItem rootMenu;

    public void execute() {
        rootMenu = new MenuDisplay(createPub());
        rootMenu.execute();
    }

    public static Pub createPub() {
        List<String> eMail = new ArrayList<>();
        List<Beer> beers = new ArrayList<>();
        eMail.add("sgasdg@gmail.com");
        eMail.add("aaaaasfs@gmail.com");
        eMail.add("bbbesfwef@gmail.com");
        Beer beer1 = new Beer(0, "Beer N1", "DE", LocalDate.parse("2004-10-25"), 45, true);
        Beer beer2 = new Beer(1, "Beer N2", "RU", LocalDate.parse("2010-10-25"), 534, true);
        Beer beer3 = new Beer(2, "Beer N3", "BY", LocalDate.parse("2012-10-25"), 12, true);
        Beer beer4 = new Beer(3, "Beer N4", "CZ", LocalDate.parse("2015-10-25"), 34, true);
        Beer beer5 = new Beer(4, "Beer N5", "AU", LocalDate.parse("2007-10-25"), 54, true);
        beers.add(beer1);
        beers.add(beer2);
        beers.add(beer3);
        beers.add(beer4);
        beers.add(beer5);
        Pub pub = null;
        pub = new Pub("Super pub", "Minsk", eMail, beers);
        return pub;
    }
}