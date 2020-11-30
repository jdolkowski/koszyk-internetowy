public class Discount200PLN extends Discount{

    public Discount200PLN() {
        super(1, 200);
    }

    @Override
    public void trigger(Basket basket, Boolean isUsed) {
        if(basket.sumPrice() > getCondition() && !isUsed){
            execute(basket);
        }
    }

    @Override
    public void execute(Basket basket) {
        Product[] tmpArray = new Product[basket.getBasket().length+1];
        System.arraycopy(basket.getBasket(),0,tmpArray, 0, basket.getBasket().length);
        tmpArray[tmpArray.length-1] = new Product("XYZ", "Kubek", 0);
        basket.setBasket(tmpArray);
        setIsUsed(true);
    }
}
