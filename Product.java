public class Product implements Comparable<Product>{
    private final String code;
    private final String name;
    private final double price;
    private double discountPrice;

    public Product(String code, String name, double price) {
        if(price < 0) throw new IllegalArgumentException("ujemna cena");
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = Double.NaN;
    }

    public Product(){
        this("0000", "untitled", 0.f);
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public int compareTo(Product x){
        return Double.compare(this.getPrice(), x.getPrice());
    }

    public String productToString(){
        return "nazwa: " + getName() + " id: " + getCode() + " price: " + getPrice() + " price after discount: " + getDiscountPrice();
    }

    public void showProductInfo(){
        System.out.println(productToString());
    }


}
