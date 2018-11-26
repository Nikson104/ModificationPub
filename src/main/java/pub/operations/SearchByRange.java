package pub.operations;

import pub.entity.Beer;
import pub.util.Range;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByRange implements SearchAction<Beer, Range> {

    @Override
    public List<Beer> execute(List<Beer> beers, Range range) {
        return beers.stream()
                .filter((beer) -> range.isAfter(beer) && range.isBefore(beer)).collect(Collectors.toList());

    }
}