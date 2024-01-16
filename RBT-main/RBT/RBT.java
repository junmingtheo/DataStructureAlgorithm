package RBT;
import java.awt.*;

import static java.awt.Color.BLACK;
import static java.awt.Color.RED;
public class RBT <T extends Comparable<T>> implements Tre<T> {
    private Node<T> root;

    @Override
    public Tre<T> insert(T Data) {
        Node<T> node = new Node<T>(Data);
        root = insert(root, node);
        recolorAndRotate(node);
        return this;
    }

    private Node<T> insert(Node<T> node, Node<T> nodeToInsert) {
        if (node == null) {
            return nodeToInsert;
        }
        if (nodeToInsert.getData().compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), nodeToInsert));
            node.getLeftChild().setParent(node);
        } else if (nodeToInsert.getData().compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), nodeToInsert));
            node.getRightChild().setParent(node);
        }
        return node;
    }

    private void recolorAndRotate(Node<T> node) {
        Node<T> parent = node.getParent();

        if (node != root && parent.getColor() == RED) {
            Node<T> GParent = parent.getParent();
            Node<T> uncle = parent.isLeftChild() ? GParent.getRightChild() : GParent.getLeftChild();
            if (uncle != null && uncle.getColor() == RED) {
                handleRecoloring(parent, uncle, GParent);
            } else if (parent.isLeftChild()) {
                handleLeftSituation(node, parent, GParent);
            } else if (!parent.isLeftChild()) {
                handleRightSituation(node, parent, GParent);
            }
        }
        root.setColor(BLACK);

    }

    private void handleRecoloring(Node<T> parent, Node<T> uncle, Node<T> gparent) {
        uncle.flipColor();
        parent.flipColor();
        gparent.flipColor();
        recolorAndRotate(gparent);
    }

    private void handleLeftSituation(Node<T> node, Node<T> parent, Node<T> gparent) {
        if (parent.isLeftChild() && !node.isLeftChild()) {
            rotateLeft(parent);
        }
        parent.flipColor();
        gparent.flipColor();
        rotateRight(gparent);
        Node<T> nodeRotate = node.isLeftChild() ? parent : gparent;
        recolorAndRotate(nodeRotate);
    }

    private void handleRightSituation(Node<T> node, Node<T> parent, Node<T> gparent) {
        if (!parent.isLeftChild() && node.isLeftChild()) {
            rotateRight(parent);
        }
        parent.flipColor();
        gparent.flipColor();
        rotateLeft(gparent);
        Node<T> nodeRotate = node.isLeftChild() ? gparent : parent;
        recolorAndRotate(nodeRotate);
    }

    private void rotateRight(Node<T> node) {
        Node<T> leftnode = node.getLeftChild();
        Node<T> centernode = leftnode.getRightChild();
        node.setLeftChild(centernode);
        if (centernode != null) {
            centernode.setParent(node);
        }
        leftnode.setRightChild(node);
        updateCOP(node, leftnode);
        leftnode.setParent(node.getParent());
        node.setParent(leftnode);
    }

    private void rotateLeft(Node<T> node) {
        Node<T> rightnode = node.getRightChild();
        Node<T> centernode = rightnode.getLeftChild();
        node.setRightChild(centernode);
        if (centernode != null) {
            centernode.setParent(node);
        }
        rightnode.setLeftChild(node);
        updateCOP(node, rightnode);
        rightnode.setParent(node.getParent());
        node.setParent(rightnode);
    }

    private void updateCOP(Node<T> node, Node<T> newNode) {
        if (node == root) {
            root = newNode;
        } else if (node.isLeftChild()) {
            node.getParent().setLeftChild(newNode);
        } else {
            node.getParent().setRightChild(newNode);
        }

    }

    public boolean isEmpty() {
        return root == null;
    }

    public T getMax() {
        if (isEmpty()) {
            return null;
        } else {
            return getMax(root);
        }

    }

    private T getMax(Node<T> node) {
        T x = node.getData();
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        } else {
            return x;
        }
    }

    public T getMin() {
        if (isEmpty()) {
            return null;
        } else {
            return getMin(root);
        }

    }

    private T getMin(Node<T> node) {
        T x = node.getData();
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        } else {
            return x;
        }
    }

    public void display() {
        displayHelper(root);
    }

    private void displayHelper(Node<T> node) {
        if (node != null) {
            displayHelper(node.getLeftChild());
            System.out.println(node.getData());
            displayHelper(node.getRightChild());
        }
    }

    public void delete(T data) {
        root = delete(root, data);
        recolorAndRotate(root);
    }

    private Node<T> delete(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(node.getLeftChild(), data));
//            node.getLeftChild().setParent(node);
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(node.getRightChild(), data));
//            node.getRightChild().setParent(node);
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            } else {
                node.setData(getMax(node.getLeftChild()));
                node.setLeftChild(delete(node.getLeftChild(), node.getData()));
                node.getLeftChild().setParent(node);
            }
        }
        return node;

    }
}



