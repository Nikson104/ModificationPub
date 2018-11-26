package pub.operations;

import java.util.InputMismatchException;
import java.util.List;

public interface SortAction<P> {
    List <P> execute(List<P> listOfObjects) throws InputMismatchException;
}