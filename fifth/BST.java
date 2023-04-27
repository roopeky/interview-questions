public class BST {
    private TreeNode root;

    public void insert(int val) {
        root = insertNode(root, val);
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        } else {
            root.count++;
        }
        return root;
    }

    public void delete(int val) {
        root = deleteNode(root, val);
    }

    private TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.count > 1) {
                root.count--;
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode minNode = findMin(root.right);
                    root.val = minNode.val;
                    root.count = minNode.count;
                    root.right = deleteNode(root.right, minNode.val);
                }
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + "(" + node.count + ") ");
            printTree(node.left);
            printTree(node.right);
        }
    }
}
