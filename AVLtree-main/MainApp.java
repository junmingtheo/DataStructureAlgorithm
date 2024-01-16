package practcode;

public class MainApp {

    /*
     * Video Reference: https://youtu.be/Jj9Mit24CWk
     */
    public static void main(String[] args) {

        Tree<Integer> avlTree = new AVLTree<>();
        avlTree.insert(10);
        avlTree.insert(2);
        avlTree.insert(6);
        avlTree.insert(8);
        avlTree.insert(25);
        avlTree.insert(18);
        avlTree.insert(35);
        avlTree.insert(15);
        avlTree.insert(22);
        avlTree.insert(42);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(12);
        avlTree.insert(17);
        avlTree.insert(19);
        avlTree.insert(24);
        avlTree.insert(28);
        avlTree.insert(33);
        avlTree.insert(38);
        avlTree.display();

        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("Deleting 42 from Tree");
        avlTree.delete(42);

        System.out.println("New Max is: " + avlTree.getMax());

        avlTree.display();

    }

}