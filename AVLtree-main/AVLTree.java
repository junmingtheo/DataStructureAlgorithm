package practcode;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {
    private Node<T> root;
    @Override
    public Tree<T> insert(T data) {
        root = insert(data, root);
        return this;
    }


    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(data, node.getLeftChild()));

        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(data, node.getRightChild()));

        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }
    @Override
    public void delete(T Data){
        if(!isEmpty()) {
           root =  delete(Data , root);
        }


    }

    private Node<T> delete(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftChild(delete(data, node.getLeftChild()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightChild(delete(data, node.getRightChild()));
        } else {

            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }
            node.setData(getMax(node.getLeftChild()));
            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
        }
        updateHeight(node);
        return applyRotation(node);

    }

    public void updateHeight(Node<T> node) {
        int maxHeight = Math.max(
                height(node.getLeftChild()),
                height(node.getRightChild())
        );
        node.setHeight(maxHeight + 1);
    }

    private int height(Node<T> node) {
        return node != null ? node.getHeight() : 0;
    }

    private int balance(Node<T> node) {
        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
    }

    private Node<T> applyRotation(Node<T> node) {
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeftChild()) < 0) {
                node.setLeftChild(rotateLeft(node.getLeftChild()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRightChild()) > 0) {
                node.setRightChild(rotateRight(node.getRightChild()));
                return rotateLeft(node);
            }
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> LeftNode = node.getLeftChild();
        Node<T> centerNode = LeftNode.getRightChild();
        LeftNode.setRightChild(node);
        node.setLeftChild(centerNode);
        updateHeight(node);
        updateHeight(LeftNode);
        return LeftNode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> RightNode = node.getRightChild();
        Node<T> centerNode = RightNode.getLeftChild();
        RightNode.setLeftChild(node);
        node.setRightChild(centerNode);
        updateHeight(node);
        updateHeight(RightNode);
        return RightNode;
    }
    @Override
    public T getMax() {
        return getMax(root);
    }
    private T getMax(Node <T> node) {
        if (isEmpty()) {
            return null;
        }
        else if (node.getRightChild() != null){
            return getMax(node.getRightChild());
        }
        return node.getData();
    }
    @Override
    public T getMin() {
        return getMin(root);
    }
    private T getMin(Node<T> node) {
        if (isEmpty()) {
            return null;
        }
        else if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
    @Override
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
    public boolean isEmpty() {
        return root == null;
    }
}

//
//public class AVLTree<T extends Comparable<T>> implements Tree<T> {
//
//    private Node<T> root;
//
//    @Override
//    public Tree<T> insert(T data) {
//        root = insert(data, root);
//        return this;
//    }
//
//    private Node<T> insert(T data, Node<T> node) {
//        if (node == null) {
//            return new Node<>(data);
//        }
//        if (data.compareTo(node.getData()) < 0) {
//            node.setLeftChild(insert(data, node.getLeftChild()));
//        } else if (data.compareTo(node.getData()) > 0) {
//            node.setRightChild(insert(data, node.getRightChild()));
//        } else {
//            return node;
//        }
//        updateHeight(node);
//        return applyRotation(node);
//    }
//
//    @Override
//    public void delete(T data) {
//        root = delete(data, root);
//    }
//
//    private Node<T> delete(T data, Node<T> node) {
//        if (node == null) {
//            return null;
//        }
//        if (data.compareTo(node.getData()) < 0) {
//            node.setLeftChild(delete(data, node.getLeftChild()));
//        } else if (data.compareTo(node.getData()) > 0) {
//            node.setRightChild(delete(data, node.getRightChild()));
//        } else {
//            // One Child or Leaf Node (no children)
//            if (node.getLeftChild() == null) {
//                return node.getRightChild();
//            } else if (node.getRightChild() == null) {
//                return node.getLeftChild();
//            }
//            // Two Children
//            node.setData(getMax(node.getLeftChild()));
//            node.setLeftChild(delete(node.getData(), node.getLeftChild()));
//        }
//        updateHeight(node);
//        return applyRotation(node);
//    }
//
//    @Override
//    public void display() {
//        traverseInOrder(root);
//    }
//
//    private void traverseInOrder(Node<T> node) {
//        if (node != null) {
//            traverseInOrder(node.getLeftChild());
//            System.out.println(node.getData());
//            traverseInOrder(node.getRightChild());
//        }
//    }
//
//    @Override
//    public T getMax() {
//        if (isEmpty()) {
//            return null;
//        }
//        return getMax(root);
//    }
//
//    private T getMax(Node<T> node) {
//        if (node.getRightChild() != null) {
//            return getMax(node.getRightChild());
//        }
//        return node.getData();
//    }
//
//    @Override
//    public T getMin() {
//        if (isEmpty()) {
//            return null;
//        }
//        return getMin(root);
//    }
//
//    private T getMin(Node<T> node) {
//        if (node.getLeftChild() != null) {
//            return getMin(node.getLeftChild());
//        }
//        return node.getData();
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    private Node<T> applyRotation(Node<T> node) {
//        int balance = balance(node);
//        if (balance > 1) {
//            if (balance(node.getLeftChild()) < 0) {
//                node.setLeftChild(rotateLeft(node.getLeftChild()));
//            }
//            return rotateRight(node);
//        }
//        if (balance < -1) {
//            if (balance(node.getRightChild()) > 0) {
//                node.setRightChild(rotateRight(node.getRightChild()));
//            }
//            return rotateLeft(node);
//        }
//        return node;
//    }
//
//    private Node<T> rotateRight(Node<T> node) {
//        Node<T> leftNode = node.getLeftChild();
//        Node<T> centerNode = leftNode.getRightChild();
//        leftNode.setRightChild(node);
//        node.setLeftChild(centerNode);
//        updateHeight(node);
//        updateHeight(leftNode);
//        return leftNode;
//    }
//
//    private Node<T> rotateLeft(Node<T> node) {
//        Node<T> rightNode = node.getRightChild();
//        Node<T> centerNode = rightNode.getLeftChild();
//        rightNode.setLeftChild(node);
//        node.setRightChild(centerNode);
//        updateHeight(node);
//        updateHeight(rightNode);
//        return rightNode;
//    }
//
//    private void updateHeight(Node<T> node) {
//        int maxHeight = Math.max(
//                height(node.getLeftChild()),
//                height(node.getRightChild())
//        );
//        node.setHeight(maxHeight + 1);
//    }
//
//    private int balance(Node<T> node) {
//        return node != null ? height(node.getLeftChild()) - height(node.getRightChild()) : 0;
//    }
//
//    private int height(Node<T> node) {
//        return node != null ? node.getHeight() : 0;
//    }
//
//}
