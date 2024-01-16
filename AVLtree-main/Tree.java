package practcode;

public interface Tree<T extends Comparable<T>> {
    Tree<T> insert(T data);
    void delete(T data);
    void display();
    T getMax();
    T getMin();
    boolean isEmpty();

}
