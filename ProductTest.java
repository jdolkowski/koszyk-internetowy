import org.junit.*;

import static org.junit.Assert.assertEquals;

public class ProductTest {
    @Test
    public void isDiscountPriceNaNTest(){
        Product sut = new Product();
        assertEquals("brak wartości", Double.NaN, sut.getDiscountPrice(), 0.0f);
    }
    @Test(expected = IllegalArgumentException.class)
    public void negativeValuePriceTest(){
        Product sut = new Product("001", "krzeslo", -1);
    }
    @Test
    public void compareToTest(){
        Product p1 = new Product("1", "krzeslo", 15);
        Product p2 = new Product("3", "talerz", 20);
        assertEquals(-1, p1.compareTo(p2));
    }
}
