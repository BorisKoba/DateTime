package telran.time;

import java.time.LocalDate;
import java.time.temporal.*;
;

public class BarMizvaAdjuster implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		if(!temporal.isSupported(ChronoUnit.YEARS)) {
			throw new UnsupportedTemporalTypeException("Not a Date");
		}
		return temporal.plus(13, ChronoUnit.YEARS);
	}

}
