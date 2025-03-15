package task;
class TeamMember implements IObserver {
    private String name;

    public TeamMember(String name) {
        this.name = name;
    }

    @Override
    public void update(String taskState) {
        System.out.println("Thành viên " + name + " nhận thông báo: Trạng thái công việc đã thay đổi thành '" + taskState + "'");
    }
}