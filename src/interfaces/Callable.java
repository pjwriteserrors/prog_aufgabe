package interfaces;

public interface Callable<T, V> {
    public T evaluate(V p);
}
