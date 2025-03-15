package task;

import java.util.ArrayList;
import java.util.List;

class Task implements ISubject {
    private String name;
    private String state;
    private List<IObserver> observers = new ArrayList<>();

    public Task(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();  // Notify team members when state changes
    }

    public String getState() {
        return state;
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(state);
        }
    }
}