package task;
public class main {
    public static void main(String[] args) {
        Task task = new Task("Phát triển API");

        TeamMember dev = new TeamMember("Tuan");
        TeamMember tester = new TeamMember("Truong");

        task.attach(dev);
        task.attach(tester);

        System.out.println("Cập nhật trạng thái công việc...");
        task.setState("Đang thực hiện");

        System.out.println("Cập nhật trạng thái công việc lần nữa...");
        task.setState("Hoàn thành");
    }
}