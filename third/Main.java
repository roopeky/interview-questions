import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printCornerNodes(root);
    }

    public static void printCornerNodes(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean isFirst = true;
            boolean isLast = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (isFirst) {
                    System.out.print(node.val + " ");
                    isFirst = false;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == levelSize - 1) {
                    System.out.print(node.val + " ");
                    isLast = true;
                }
            }

            if (!isLast) {
                System.out.print(queue.peek().val + " ");
            }

            System.out.println();
        }
    }
}