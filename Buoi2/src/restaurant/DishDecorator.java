package restaurant;
abstract class DishDecorator implements Dish {
    protected Dish wrapped;

    public DishDecorator(Dish wrapped) {
        this.wrapped = wrapped;
    }
}