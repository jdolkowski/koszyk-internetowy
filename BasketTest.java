import org.junit.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasketTest {
    @Test
    public void show(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        sut.showBasketInfo();
    }
    @Test
    public void priceSumTest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        assertEquals(55.f, sut.sumPrice(), 0.f);
    }
    @Test
    public void priceSumNaNTest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        p3.setDiscountPrice(25.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        assertEquals(50.f, sut.sumPrice(), 0.f);
    }
    @Test
    public void sortDescendingTest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        sut.sortDescending();
        assertArrayEquals(new Product[]{p3,p1,p2}, sut.getBasket());
    }
    @Test
    public void sortAscendingTest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        sut.sortAscending();
        assertArrayEquals(new Product[]{p2,p1,p3}, sut.getBasket());
    }
    @Test
    public void sortAlphabeticallyTest(){
        Product p1 = new Product("1","crzeslo", 15.f);
        Product p2 = new Product("2","ztol", 10.f);
        Product p3 = new Product("3", "aalerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        sut.sortAlphabetically();
        assertArrayEquals(new Product[]{p3,p1,p2}, sut.getBasket());
    }
    @Test
    public void findTheMostExpensiveTest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        Product theMostExpensive = sut.findTheMostExpensive();
        assertEquals("najdrozszy", p3, theMostExpensive);
    }
    @Test
    public void findTheCheapest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        Product theCheapest = sut.findTheCheapest();
        assertEquals("najtanszy", p2, theCheapest);
    }
    @Test
    public void findTheNCheapest(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        assertArrayEquals(new Product[]{p2,p1}, sut.findNProductExtremes(2, "MIN"));
    }
    @Test
    public void findTheNMostExpensive(){
        Product p1 = new Product("1","krzeslo", 15.f);
        Product p2 = new Product("2","stol", 10.f);
        Product p3 = new Product("3", "talerze", 30.f);
        Product[] productArray = new Product[]{p1,p2,p3};
        Basket sut = new Basket(productArray);
        assertArrayEquals(new Product[]{p3,p1}, sut.findNProductExtremes(2, "MAX"));
    }

}
