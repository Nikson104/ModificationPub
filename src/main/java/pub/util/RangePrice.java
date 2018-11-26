package pub.util;

import pub.entity.Beer;

public class RangePrice extends Range<Integer> {
    public RangePrice(int priceFrom, int priceTo) {
        super(priceFrom, priceTo);
    }

    @Override
    public boolean isAfter(Beer beer) {
        return beer.getPrice() >= this.getFrom();
    }

    @Override
    public boolean isBefore(Beer beer) {
        return beer.getPrice() <= this.getTo();
    }
}
