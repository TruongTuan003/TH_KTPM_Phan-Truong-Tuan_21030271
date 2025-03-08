package design_pattern;
class DecoratorPattern {
    private Order order;

    public DecoratorPattern(Order order) {
        this.order = order;
    }

    public void describe() {
        System.out.println("Đơn hàng cơ bản, đang xử lý theo yêu cầu.");
    }
    public static void main(String[] args) {
        System.out.println("Test Decorator Pattern:");
        Order order = new Order();
        DecoratorPattern decorator = new DecoratorPattern(order);
        
        System.out.println("Chỉ gọi đơn hàng cơ bản:");
        order.describeBasic();
        System.out.println("Gọi với decorator:");
        decorator.describe();
    }
}