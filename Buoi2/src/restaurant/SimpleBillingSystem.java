package restaurant;
public class SimpleBillingSystem {
    public static void main(String[] args) {
        System.out.println("Test Hệ thống tính tiền món ăn đơn giản:");
        
        // Món ăn cơ bản
        Dish basicDish = new BasicDish();
        System.out.println("Chỉ gọi món cơ bản:");
        basicDish.describe();
        System.out.println("---");

        // Món ăn + nước uống
        Dish withDrink = new DrinkDecorator(new BasicDish());
        System.out.println("Món ăn với nước uống:");
        withDrink.describe();
        System.out.println("---");

        // Món ăn + nước uống + giao hàng
        Dish fullOrder = new DeliveryDecorator(new DrinkDecorator(new BasicDish()));
        System.out.println("Món ăn với nước uống và giao hàng:");
        fullOrder.describe();
    }
}