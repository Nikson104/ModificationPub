package by.itacademy.pub;

import org.junit.Assert;
import org.junit.Test;
import pub.entity.Beer;
import pub.entity.Beers;
import pub.util.RangeDate;
import pub.util.RangePrice;

import java.time.LocalDate;
import java.util.List;

public class BeerSearchByRangeTest {
    @Test
    public void searchByPriceShouldBeValid() {
        Beers beers = new Beers();
        beers.add(new Beer(1, "Beer2", "RU", LocalDate.parse("2010-10-25"), 534, true));
        beers.add(new Beer(0, "Beer1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        beers.add(new Beer(2, "Beer1", "BY", LocalDate.parse("2012-10-25"), 12, true));
        beers.add(new Beer(3, "Beer4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        beers.add(new Beer(4, "Beer5", "AU", LocalDate.parse("2007-10-25"), 54, true));

        List<Beer> filtered = beers.searchByPrice(new RangePrice(45,100));

        Assert.assertEquals(filtered.size(), 2);
    }
    @Test
    public void searchByDateProductionShouldBeValid() {
        Beers beers = new Beers();
        beers.add(new Beer(1, "Beer2", "RU", LocalDate.parse("2010-10-25"), 534, true));
        beers.add(new Beer(0, "Beer1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        beers.add(new Beer(2, "Beer3", "BY", LocalDate.parse("2012-10-25"), 12, true));
        beers.add(new Beer(3, "Beer4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        beers.add(new Beer(4, "Beer5", "AU", LocalDate.parse("2007-10-25"), 54, true));

        List<Beer> filtered = beers.searchByDateProduction(
                new RangeDate(LocalDate.parse("2010-10-25"),LocalDate.parse("2015-10-25")));

        Assert.assertEquals(filtered.size(), 3);
    }
}