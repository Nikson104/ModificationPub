package pub.util;

import pub.entity.Beer;

public abstract class Range<T> {

    public Range(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public abstract boolean isAfter(Beer property);
    public abstract boolean isBefore(Beer property);

    public T getFrom() {
        return from;
    }


    public T getTo() {
        return to;
    }

    private T from;
    private T to;
}