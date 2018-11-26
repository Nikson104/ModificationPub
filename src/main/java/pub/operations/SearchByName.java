package pub.operations;

import pub.entity.Beer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByName implements SearchAction<Beer, String> {

    @Override
    public List<Beer> execute(List<Beer> beers, String name) throws InputMismatchException {
        return beers.stream()
                .filter((beer) -> beer.getName().equals(name)).collect(Collectors.toList());
    }
}