package design_pattern;
class StatePattern {
    private Order order;
    private String currentState;
    private StrategyPattern strategyPattern;

    public StatePattern(Order order) {
        this.order = order;
        this.currentState = "New"; // Trạng thái ban đầu
        this.strategyPattern = new StrategyPattern();
    }

    public void process() {
        switch (currentState) {
            case "New":
                strategyPattern.execute("CheckOrderInfo");
                System.out.println("Đơn hàng chuyển sang trạng thái Đang xử lý.");
                currentState = "Processing";
                break;
            case "Processing":
                strategyPattern.execute("PackAndShip");
                System.out.println("Đơn hàng chuyển sang trạng thái Đã giao.");
                currentState = "Delivered";
                break;
            case "Delivered":
                System.out.println("Đơn hàng đã được giao.");
                break;
            case "Cancelled":
                System.out.println("Đơn hàng đã hủy, không thể xử lý.");
                break;
        }
    }

    public void cancel() {
        if (currentState.equals("Delivered")) {
            System.out.println("Đơn hàng đã giao không thể hủy.");
        } else if (!currentState.equals("Cancelled")) {
            System.out.println("Đơn hàng đã bị hủy.");
            strategyPattern.execute("Refund");
            currentState = "Cancelled";
        } else {
            System.out.println("Đơn hàng đã được hủy trước đó.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Test State Pattern:");
        Order order = new Order();
        order.process(); // New -> Processing
        order.process(); // Processing -> Delivered
        order.cancel();  // Không thể hủy khi đã giao
        System.out.println("---");

        Order order2 = new Order();
        order2.cancel(); // Hủy đơn hàng mới tạo
    }
    
}