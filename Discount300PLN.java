public class Discount300PLN extends Discount {

    public Discount300PLN(){
        super(0.95, 300);
    }
    @Override
    public void trigger(Basket basket, Boolean isUsed) {
        if(basket.sumPrice() > getCondition() && !isUsed){
            execute(basket);
        }
    }

    @Override
    public void execute(Basket basket) {
        for(Product i : basket.getBasket()){
            i.setDiscountPrice(i.getPrice()*getDiscountAmount());
        }
        setIsUsed(true);
    }
}
