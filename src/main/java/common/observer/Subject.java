package common.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject<T> implements Observable<T>, Publisher<T> {

    private final List<Observer<T>> observers = new ArrayList<>();
    private T value;

    @Override
    public void suscribe(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void unSuscribe(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(T value) {
        this.value = value;
        observers.forEach(observer -> observer.update(value));
    }
}
