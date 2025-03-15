package stock;
public class main {
    public static void main(String[] args) {
        Stock appleStock = new Stock("Apple", 150.00);

        Investor investor1 = new Investor("Tuan");
        Investor investor2 = new Investor("Truong");

        appleStock.attach(investor1);
        appleStock.attach(investor2);

        // Thay đổi giá cổ phiếu và thông báo đến các nhà đầu tư
        System.out.println("Giá cổ phiếu thay đổi...");
        appleStock.setPrice(155.00);

        // Gỡ bỏ một nhà đầu tư và cập nhật giá tiếp theo
        appleStock.detach(investor1);
        System.out.println("Giá cổ phiếu thay đổi lần nữa...");
        appleStock.setPrice(160.00);
    }
}