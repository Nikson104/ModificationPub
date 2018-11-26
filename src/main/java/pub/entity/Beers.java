package pub.entity;

import pub.operations.*;
import pub.util.Range;
import pub.util.RangeDate;
import pub.util.RangePrice;

import java.util.*;

public class Beers {

    private List<Beer> beers;
    private final SortByName sortByName = new SortByName();
    private final SortByPrice sortByPrice = new SortByPrice();
    private final SearchByName searchByName = new SearchByName();
    private final SearchByRange searchByRange = new SearchByRange();
    private final SearchByRegion searchByRegion = new SearchByRegion();
    private final InfoSimilarBeer infoSimilarBeer = new InfoSimilarBeer();

    public Beers() {
        beers = new ArrayList<>();
    }

    public void add(Beer beer) {
        beers.add(beer);
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void sortByName() {
        sortByName.execute(beers);
    }

    public void sortByPrice() {
        sortByPrice.execute(beers);
    }

    public List<Beer> searchByName (String name){
        return searchByName.execute(beers,name);
    }

    public List<Beer> searchByPrice (Range priceRange){
        return searchByRange.execute(beers,priceRange );
    }

    public List<Beer> searchByDateProduction (Range dateRange){
        return searchByRange.execute(beers,dateRange);
    }

    public List<Beer> InfoSimilarBeer(Beer beer){
        return infoSimilarBeer.execute(beers,beer);
    }

    public List<Beer> searchByRegion (String region){
        return searchByRegion.execute(beers,region);
    }

    @Override
    public String toString() {
        return "Beers{" +
                "beers=" + beers +
                '}';
    }
}
