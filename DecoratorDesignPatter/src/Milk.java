public class Milk extends IngredientDecorator{

    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int getBeveragePrice() {
        return beverage.getBeveragePrice() + 2;
    }

    @Override
    String getBeverageName() {
        return beverage.getBeverageName() + " with milk";
    }
}
