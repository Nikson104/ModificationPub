package by.itacademy.pub;

import org.junit.Assert;
import org.junit.Test;
import pub.entity.Beer;
import pub.entity.Beers;

import java.time.LocalDate;

public class BeerSortByPriceTest {
    @Test
    public void sortByPriceShouldBeValid() {
        Beers beers = new Beers();
        beers.add(new Beer(0, "Beer N1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        beers.add(new Beer(1, "Beer N2", "RU", LocalDate.parse("2010-10-25"), 534, true));
        beers.add(new Beer(2, "Beer N3", "BY", LocalDate.parse("2012-10-25"), 12, true));
        beers.add(new Beer(3, "Beer N4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        beers.add(new Beer(4, "Beer N5", "AU", LocalDate.parse("2007-10-25"), 54, true));

        beers.sortByPrice();

        Beers expected = new Beers();
        expected.add(new Beer(2, "Beer N3", "BY", LocalDate.parse("2012-10-25"), 12, true));
        expected.add(new Beer(3, "Beer N4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        expected.add(new Beer(0, "Beer N1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        expected.add(new Beer(4, "Beer N5", "AU", LocalDate.parse("2007-10-25"), 54, true));
        expected.add(new Beer(1, "Beer N2", "RU", LocalDate.parse("2010-10-25"), 534, true));

        Assert.assertEquals(expected.getBeers(), beers.getBeers());
    }

    @Test
    public void sortByNameShouldBeInvalid() {
        Beers beers = new Beers();
        beers.add(new Beer(1, "Beer N2", "RU", LocalDate.parse("2010-10-25"), 534, true));
        beers.add(new Beer(0, "Beer N1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        beers.add(new Beer(2, "Beer N3", "BY", LocalDate.parse("2012-10-25"), 12, true));
        beers.add(new Beer(3, "Beer N4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        beers.add(new Beer(4, "Beer N5", "AU", LocalDate.parse("2007-10-25"), 54, true));

        beers.sortByPrice();

        Beers expected = new Beers();
        expected.add(new Beer(2, "Beer N3", "BY", LocalDate.parse("2012-10-25"), 12, true));
        expected.add(new Beer(3, "Beer N4", "CZ", LocalDate.parse("2015-10-25"), 34, true));
        expected.add(new Beer(0, "Beer N1", "DE", LocalDate.parse("2004-10-25"), 45, true));
        expected.add(new Beer(1, "Beer N2", "RU", LocalDate.parse("2010-10-25"), 534, true));
        expected.add(new Beer(4, "Beer N5", "AU", LocalDate.parse("2007-10-25"), 54, true));

        Assert.assertNotEquals(expected, beers);
    }
}
