package RBT;
import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
@Data
public class Node <T extends Comparable<T>> {
    @NonNull
    private T Data;
    private Node<T> LeftChild;
    private Node<T> RightChild;
    @ToString.Exclude
    private Node<T> parent;
    private Color color = RED;

    public boolean isLeftChild() {
        return this == parent.getLeftChild();
    }

    public void flipColor() {
        setColor(color == RED ? BLACK : RED);
    }

}