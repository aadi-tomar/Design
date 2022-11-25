public class CoffeeHouse {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
        beverage = new Caramel(beverage);
        beverage = new Milk(beverage);

        System.out.println(beverage.getBeverageName());
        System.out.println(beverage.getBeveragePrice());
    }
}
