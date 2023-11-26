package pl.ReFZero.generic;

public class Box<T> implements BoxInterface<T>{
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
