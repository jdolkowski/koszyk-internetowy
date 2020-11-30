public class Buy3get1 extends Discount {


    public Buy3get1() {
        super(0.f, Double.NaN);
    }

    @Override
    public void trigger(Basket basket, Boolean isUsed) {
        if(getNumberOfFreeItems(basket) >= 1 && !isUsed){
            execute(basket);
        }
    }

    @Override
    public void execute(Basket basket) {
        Product[] freeItems = basket.findNProductExtremes(getNumberOfFreeItems(basket), "MIN");
        for(Product i : basket.getBasket()){
            for(Product j : freeItems){
                if(i.getCode().equals(j.getCode())){
                    i.setDiscountPrice(i.getPrice()*getDiscountAmount());
                }
            }
        }
    }
    public int getNumberOfFreeItems(Basket basket){

        return basket.getBasket().length / 3;
    }
}
