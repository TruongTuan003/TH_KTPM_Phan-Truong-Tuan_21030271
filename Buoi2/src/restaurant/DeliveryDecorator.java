package restaurant;
class DeliveryDecorator extends DishDecorator {
    public DeliveryDecorator(Dish wrapped) {
        super(wrapped);
    }

    @Override
    public void describe() {
        wrapped.describe();
        System.out.println("Thêm dịch vụ giao hàng vào đơn hàng...");
    }
}