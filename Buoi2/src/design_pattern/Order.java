package design_pattern;
class Order {
    private StatePattern statePattern;

    public Order() {
        this.statePattern = new StatePattern(this); // Trạng thái ban đầu
    }

    public void setStatePattern(StatePattern statePattern) {
        this.statePattern = statePattern;
    }

    public void process() {
        statePattern.process();
    }

    public void cancel() {
        statePattern.cancel();
    }
    public void describeBasic() {
        System.out.println("Đơn hàng cơ bản.");
    }
}