package stock;
class Investor implements Observer {
    private String name;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update(double price) {
        System.out.println("Nhà đầu tư " + name + " nhận thông báo: Giá cổ phiếu thay đổi thành " + price);
    }
}