package pub.menu.search;

import pub.entity.Beer;
import pub.entity.Pub;
import pub.menu.MenuItem;
import pub.menu.MenuItemName;
import pub.menu.RootMenuItem;
import pub.operations.InfoSimilarBeer;

@MenuItemName(value = "Info about similar kind of beer", number = 6)
public class MenuInfoSimilarBeer extends MenuSearchOperation implements Runnable {
    public MenuInfoSimilarBeer(RootMenuItem rootMenu, Pub pub) {
        super(new InfoSimilarBeer(), rootMenu, pub);
    }


    @Override
    public void perform() {
        System.out.println("Please select your favorite beer number: " + pub.getBeers());
        int beerNumber = SCANNER.nextInt();
        Beer favoriteBeer = pub.getBeers().get(beerNumber);
        execute(favoriteBeer);
    }

    @Override
    public void run() {
        perform();
    }
}