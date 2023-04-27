import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // Vertical sums in a binary tree exercise
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Map<Integer, Integer> verticalSums = verticalSum(root);

        for (int hd : verticalSums.keySet()) {
            System.out.println("Vertical sum at hd=" + hd + ": " + verticalSums.get(hd));
        }
    }

    public static Map<Integer, Integer> verticalSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        verticalSumHelper(root, map, 0);
        return map;
    }

    private static void verticalSumHelper(TreeNode root, Map<Integer, Integer> map, int hd) {
        if (root == null) {
            return;
        }

        int sum = map.getOrDefault(hd, 0);
        map.put(hd, sum + root.val);

        verticalSumHelper(root.left, map, hd - 1);
        verticalSumHelper(root.right, map, hd + 1);
    }
}
