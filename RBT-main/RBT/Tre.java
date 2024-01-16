package RBT;

public interface Tre <T extends Comparable<T>>{
    Tre<T> insert(T Data);
    void delete(T data);
    void display();
    T getMax();
    T getMin();
    boolean isEmpty();
}
