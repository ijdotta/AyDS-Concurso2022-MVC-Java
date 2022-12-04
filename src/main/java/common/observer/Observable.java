package common.observer;

public interface Observable<T> {
    void suscribe(Observer<T> observer);
    void unSuscribe(Observer<T> observer);
}

interface Publisher<T> {
    void notify(T value);
}