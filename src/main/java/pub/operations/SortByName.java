package pub.operations;

import pub.entity.Beer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements SortAction<Beer> {

    @Override
    public List<Beer> execute(List<Beer> beers) {
        beers.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return beers;
    }

}