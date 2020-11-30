public abstract class Discount {
    protected double discountAmount;
    protected double condition;
    protected Boolean isUsed;

    public Discount( double discountAmount, double condition){
        this.discountAmount = discountAmount;
        this.condition = condition;
        this.isUsed = false;
    }
    public abstract void trigger(Basket basket, Boolean isUsed);
    public abstract void execute(Basket basket);
    public final double getDiscountAmount(){
        return discountAmount;
    }
    protected final double getCondition(){
        return condition;
    }
    public final Boolean getIsUsed(){
        return isUsed;
    }
    protected void setIsUsed(Boolean isUsed){
        this.isUsed = isUsed;
    }
}
