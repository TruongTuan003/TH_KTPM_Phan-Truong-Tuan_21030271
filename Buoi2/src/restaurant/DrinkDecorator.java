package restaurant;
class DrinkDecorator extends DishDecorator {
    public DrinkDecorator(Dish wrapped) {
        super(wrapped);
    }

    @Override
    public void describe() {
        wrapped.describe();
        System.out.println("Thêm nước uống vào đơn hàng...");
    }
}