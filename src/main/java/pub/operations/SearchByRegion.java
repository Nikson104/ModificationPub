package pub.operations;

import pub.entity.Beer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByRegion implements SearchAction<Beer, String> {

    @Override
    public List<Beer> execute(List<Beer> beers, String region) throws InputMismatchException {
        return beers.stream()
                .filter((beer) -> beer.getCountry().equals(region)).collect(Collectors.toList());
    }
}