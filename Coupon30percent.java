public class Coupon30percent extends Discount{

    public Coupon30percent() {
        super(0.70, Double.NaN);
    }

    @Override
    public void trigger(Basket basket, Boolean isUsed) {
        if(!isUsed){execute(basket);}
    }

    @Override
    public void execute(Basket basket) {
        basket.findTheMostExpensive().setDiscountPrice(basket.findTheMostExpensive().getPrice() * getDiscountAmount());
        setIsUsed(true);
    }

}
