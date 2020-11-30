import java.util.*;

import static java.lang.Double.isNaN;

public class Basket {
    private Product[] productList;
    private Discount[] discountList;


    public Basket(Product[] productList){
        this(productList, null);
    }
    public Basket(Product[] productList, Discount[] discountList) {
        this.productList = productList;
        this.discountList = discountList;
    }
    public final Product[] getBasket(){
        return productList;
    }
    public void setBasket(Product[] array){
        this.productList = array;
    }

    public Product findTheMostExpensive() {
        return findNProductExtremes(1, "MAX")[0];
    }
    public Product findTheCheapest(){
        return findNProductExtremes(1,"MIN")[0];
    }

    public Product[] findNProductExtremes(int n, String typeOfExtreme) {
        if(n > productList.length || n <= 0){throw new IllegalArgumentException("niepoprawna liczba produktów");}

        Product[] tmpProductList = new Product[n];

        if(typeOfExtreme.equals("MAX")){
            sortDescending();
        }else if(typeOfExtreme.equals("MIN")){
            sortAscending();
        }
        System.arraycopy(productList, 0, tmpProductList, 0, tmpProductList.length);
        return tmpProductList;
    }

    public void sortAscending() {
        Arrays.sort(productList);
    }

    public void sortDescending() {
        Arrays.sort(productList, Collections.reverseOrder());
    }

    public void sortAlphabetically(){
        Arrays.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public double sumPrice(){
        double sum = 0;
        for(Product i : productList){
            if(isNaN(i.getDiscountPrice())){
                sum += i.getPrice();
            } else {
                sum += i.getDiscountPrice();
            }
        }
        return sum;
    }

    public void showBasketInfo(){
        for(Product i : productList){
            System.out.println("-------------------");
            i.showProductInfo();
        }
    }

    public void discounts(Basket basket){
        for(Discount i : basket.discountList){
            i.trigger(basket, i.getIsUsed());
        }
    }


}
