package pub.util;

import pub.entity.Beer;

import java.time.LocalDate;

public class RangeDate extends Range<LocalDate>{

    public RangeDate(LocalDate from, LocalDate to) {
        super(from, to);
    }

    public boolean isAfter(Beer beer){
        return beer.getProducedTime().isAfter(this.getFrom())
                || beer.getProducedTime().isEqual(this.getFrom());
    }

    public boolean isBefore(Beer beer){
        return beer.getProducedTime().isBefore(this.getTo())
                || beer.getProducedTime().isEqual(this.getTo());
    }
}
