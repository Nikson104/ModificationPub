package pub.operations;

import pub.entity.Beer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class InfoSimilarBeer implements SearchAction<Beer, Beer> {

    @Override
    public List<Beer> execute(List<Beer> beers, Beer param) throws InputMismatchException {
        String selectedCountry = param.getCountry();
        return beers.stream()
                .filter((beer) -> beer.getCountry().equals(selectedCountry)).collect(Collectors.toList());
    }
}