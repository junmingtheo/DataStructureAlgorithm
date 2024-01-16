package RBT;

public class MainApp {
    public static void main(String[] args) {

        Tre<Integer> redBlackTree = new RBT<Integer>();
        redBlackTree.insert(10);
        redBlackTree.insert(20);
        redBlackTree.insert(5);
        redBlackTree.insert(40);
        redBlackTree.insert(50);
        redBlackTree.insert(25);
        redBlackTree.insert(60);
        redBlackTree.insert(80);
        redBlackTree.insert(85);
        redBlackTree.insert(90);
        redBlackTree.insert(30);
        redBlackTree.insert(15);
        redBlackTree.insert(75);
        redBlackTree.insert(100);
        redBlackTree.insert(55);
        redBlackTree.insert(45);
        redBlackTree.insert(0);
        redBlackTree.insert(26);
        redBlackTree.delete(45);
        redBlackTree.delete(100);
        redBlackTree.delete(100);

        redBlackTree.display();


        System.out.println("Max is: " + redBlackTree.getMax());
        System.out.println("Min is: " + redBlackTree.getMin());
    }
}