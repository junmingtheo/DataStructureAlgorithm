package practcode;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node<T extends Comparable<T>> {

    @NonNull
    private T data;

    private int height = 1;

    private Node<T> LeftChild;
    private Node<T> RightChild;

}