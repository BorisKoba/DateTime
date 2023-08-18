package telran.time.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.time.BarMizvaAdjuster;
import telran.time.NextFriday13;

class TemporalTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Disabled
	void test() {
		LocalDate birthDateAS = LocalDate.of(1799, 06, 06);
		LocalDate barMizvaAS = birthDateAS.plusYears(13);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM, YYYY/d EEE");
		System.out.printf("Birthdate of AS is %s \n",birthDateAS.format(dtf));
		ChronoUnit unit = ChronoUnit.WEEKS;
		System.out.printf("Number of %s between %s and %s is %d\n",unit,
				birthDateAS, barMizvaAS, unit.between(birthDateAS, barMizvaAS));
	}
	@Test
	void barMizvaAdjusterTest() {
		TemporalAdjuster adjuster = new BarMizvaAdjuster();
		LocalDateTime ldt = LocalDateTime.of(2000, 1, 1, 0, 0);
		LocalDateTime expected = LocalDateTime.of(2013, 1, 1, 0, 0);
		assertEquals(expected, ldt.with(new BarMizvaAdjuster()));
		assertThrowsExactly(UnsupportedTemporalTypeException.class, ()->LocalTime.now().with(adjuster));
	}
	@Test
	void nextFridayAdjusterTest() {
		TemporalAdjuster adjuster = new NextFriday13();
		LocalDate ld = LocalDate.of(2023, 8, 15);
		LocalDate expected1 = LocalDate.of(2023, 10, 13);
		LocalDate expected2 = LocalDate.of(2024, 9, 13);
		assertEquals(expected1, ld.with(adjuster));
		assertEquals(expected2, expected1.with(adjuster));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
