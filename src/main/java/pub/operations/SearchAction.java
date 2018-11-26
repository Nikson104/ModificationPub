package pub.operations;

import java.util.InputMismatchException;
import java.util.List;

public interface SearchAction<P, T> {
    List <P> execute(List<P> beers, T param) throws InputMismatchException;
}