import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100) + 1;
        }

        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < arr.length; i++) {
            tree.insert(arr[i]);
        }

        System.out.println("Binary Search Tree (Inorder Traversal): ");
        tree.inorder();

        int deleteNodeValue = arr[rand.nextInt(arr.length - 1)];
        tree.delete(deleteNodeValue);
        System.out.println("\nAfter deleting node with value " + deleteNodeValue + ": ");
        tree.inorder();

        int newNodeValue = rand.nextInt(100) + 1;
        tree.insert(newNodeValue);
        System.out.println("\nAfter inserting node with value " + newNodeValue + ": ");
        tree.inorder();
    }
}
