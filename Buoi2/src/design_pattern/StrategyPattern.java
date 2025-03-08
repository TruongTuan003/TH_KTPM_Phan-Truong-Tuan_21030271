package design_pattern;
class StrategyPattern {
    public void execute(String action) {
        switch (action) {
            case "CheckOrderInfo":
                System.out.println("Đang kiểm tra thông tin đơn hàng...");
                break;
            case "PackAndShip":
                System.out.println("Đang đóng gói và vận chuyển đơn hàng...");
                break;
            case "Refund":
                System.out.println("Đang hoàn tiền cho khách hàng...");
                break;
            default:
                System.out.println("Hành vi không xác định.");
        }
    }
    public static void main(String[] args) {
        System.out.println("Test Strategy Pattern:");
        StrategyPattern strategy = new StrategyPattern();
        strategy.execute("CheckOrderInfo"); // Kiểm tra thông tin
        strategy.execute("PackAndShip");    // Đóng gói và vận chuyển
        strategy.execute("Refund");         // Hoàn tiền
        strategy.execute("Unknown");        // Hành vi không xác định
    }
}