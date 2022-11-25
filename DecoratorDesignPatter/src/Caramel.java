public class Caramel extends  IngredientDecorator{

    Beverage beverage;

    public Caramel(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getBeveragePrice() {
        return beverage.getBeveragePrice() + 5;
    }

    @Override
    String getBeverageName() {
        return beverage.getBeverageName() + " with caramel ";
    }
}
