
public class Main {
    public static void main(String[] args) {
        BST bst = new BST();

        // Insert values into the BST
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(5);
        bst.insert(2);
        bst.insert(5);
        bst.insert(8);

        // Initial state of the BST
        System.out.println("Initial BST:");
        bst.printTree();

        // Delete values from the BST
        bst.delete(5);
        bst.delete(3);
        bst.delete(8);

        // Print the final state of the BST
        System.out.println("\nFinal BST:");
        bst.printTree();
    }
}