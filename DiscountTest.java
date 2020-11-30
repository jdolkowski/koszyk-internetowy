import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiscountTest {
    @Test
    public void Discount300PLNTest(){
        Product p1 = new Product("1","krzeslo", 150.f);
        Product p2 = new Product("2","stol", 200.f);
        Product p3 = new Product("3", "talerze", 300.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Discount[] discountArray = new Discount[]{new Discount300PLN()};
        Basket basket = new Basket(productArray, discountArray);
        double priceBefore = basket.sumPrice();
        basket.discounts(basket);
        assertEquals(basket.sumPrice(), priceBefore * 0.95, 0.00001);
    }
    @Test
    public void Discount200PLNTest(){
        Product p1 = new Product("1","krzeslo", 150.f);
        Product p2 = new Product("2","stol", 200.f);
        Product p3 = new Product("3", "talerze", 300.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Discount[] discountArray = new Discount[]{new Discount200PLN()};
        Basket basket = new Basket(productArray, discountArray);

        basket.discounts(basket);
        assertEquals("XYZ", basket.getBasket()[basket.getBasket().length-1].getCode());
    }
    @Test
    public void Buy3get1Test(){
        Product p1 = new Product("1","krzeslo", 150.f);
        Product p2 = new Product("2","stol", 200.f);
        Product p3 = new Product("3", "talerze", 300.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Discount[] discountArray = new Discount[]{new Buy3get1()};
        Basket basket = new Basket(productArray, discountArray);
        double priceBefore = basket.sumPrice();
        basket.discounts(basket);
        assertEquals(basket.sumPrice(), priceBefore - 150, 0.0000001);
    }

    @Test
    public void Coupon30percentTest(){
        Product p1 = new Product("1","krzeslo", 150.f);
        Product p2 = new Product("2","stol", 200.f);
        Product p3 = new Product("3", "talerze", 300.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Discount[] discountArray = new Discount[]{new Coupon30percent()};
        Basket basket = new Basket(productArray, discountArray);
        double priceBefore = basket.sumPrice();
        basket.discounts(basket);
        assertEquals(basket.sumPrice(), priceBefore - (300 * 0.3), 0.0000001);
    }
    @Test
    public void Buy7get2Test(){
        Product p1 = new Product("1","krzeslo", 150.f);
        Product p2 = new Product("2","stol", 200.f);
        Product p3 = new Product("3", "talerze", 300.f);
        Product p4 = new Product("4","komin", 350.f);
        Product p5 = new Product("5","myszka", 100.f);
        Product p6 = new Product("6", "monitor", 250.f);
        Product p7 = new Product("7", "monitor", 500.f);
        Product[] productArray = new Product[]{p1,p2,p3,p4,p5,p6,p7};
        Discount[] discountArray = new Discount[]{new Buy3get1()};
        Basket basket = new Basket(productArray, discountArray);
        double priceBefore = basket.sumPrice();
        basket.discounts(basket);
        assertEquals(basket.sumPrice(), priceBefore - (150+100), 0.0000001);
    }

}
