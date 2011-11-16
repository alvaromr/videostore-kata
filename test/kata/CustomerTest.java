package kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testStatement() {
		Movie movie = new Movie("Heat",1);
		Rental r = new Rental(movie, 2);
		Customer c = new Customer("Ernesto Arroyo");
		c.addRental(r);
		String st = c.statement();
		assertEquals("fail", st);
	}
}
