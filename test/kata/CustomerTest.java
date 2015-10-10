package kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private String name;

    @Before
    public void setUp() {
        name = "Alvaro Martin";
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalPrice(){
        Movie movie = new Movie("Ilegal", -1);
    }

    @Test
    public void testNewRelease() {
        Movie movie = new Movie("Heat", PriceFactory.NEW_RELEASE);
        Rental r = new Rental(movie, 2);
        Customer c = new Customer(name);
        c.addRental(r);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tHeat\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", st);
        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Heat</td><td>6.0</td></tr></table>" +
                "<p>Amount owed is 6.0</p>" +
                "<p>You earned 2 frequent renter points</p>", html);
    }

    @Test
    public void testChildrensMenosDe3Dias() {
        Movie movie = new Movie("Cars2", PriceFactory.CHILDRENS);
        Rental r = new Rental(movie, 2);
        Customer c = new Customer(name);
        c.addRental(r);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tCars2\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", st);
        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Cars2</td><td>1.5</td></tr></table>" +
                "<p>Amount owed is 1.5</p>" +
                "<p>You earned 1 frequent renter points</p>", html);
    }

    @Test
    public void testChildrensMasDe3Dias() {
        Movie movie = new Movie("Cars2", PriceFactory.CHILDRENS);
        Rental r = new Rental(movie, 7);
        Customer c = new Customer(name);
        c.addRental(r);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tCars2\t7.5\n" +
                "Amount owed is 7.5\n" +
                "You earned 1 frequent renter points", st);
        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Cars2</td><td>7.5</td></tr></table>" +
                "<p>Amount owed is 7.5</p>" +
                "<p>You earned 1 frequent renter points</p>", html);
    }

    @Test
    public void testRegularMenosDe3Dias() {
        Movie movie = new Movie("Torero", PriceFactory.REGULAR);
        Rental r = new Rental(movie, 2);
        Customer c = new Customer(name);
        c.addRental(r);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tTorero\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", st);
        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Torero</td><td>2.0</td></tr></table>" +
                "<p>Amount owed is 2.0</p>" +
                "<p>You earned 1 frequent renter points</p>", html);
    }

    @Test
    public void testRegularMasDe3Dias() {
        Movie movie = new Movie("Torero", PriceFactory.REGULAR);
        Rental r = new Rental(movie, 5);
        Customer c = new Customer(name);
        c.addRental(r);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tTorero\t6.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 1 frequent renter points", st);
        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Torero</td><td>6.5</td></tr></table>" +
                "<p>Amount owed is 6.5</p>" +
                "<p>You earned 1 frequent renter points</p>", html);
    }

    @Test
    public void testDeTodoUnPoco() {
        Movie movie = new Movie("Torero", PriceFactory.REGULAR);
        Movie movie2 = new Movie("Cars2", PriceFactory.CHILDRENS);
        Rental r = new Rental(movie, 5);
        Rental r2 = new Rental(movie2, 2);
        Customer c = new Customer(name);
        c.addRental(r);
        c.addRental(r2);
        String st = c.statement();
        assertEquals("Rental Record for " + name + "\n" +
                "\tTorero\t6.5\n" +
                "\tCars2\t1.5\n" +
                "Amount owed is 8.0\n" +
                "You earned 2 frequent renter points", st);

        String html = c.statementHTML();
        assertEquals("<h1>Rental Record for " + name + "</h1>" +
                "<table><tr><td>Torero</td><td>6.5</td></tr>" +
                "<tr><td>Cars2</td><td>1.5</td></tr></table>" +
                "<p>Amount owed is 8.0</p>" +
                "<p>You earned 2 frequent renter points</p>", html);
    }
}
