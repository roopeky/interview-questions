public class Main {
    public static void main(String[] args) {
        // sub-tree exercise
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(2);

        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        boolean isSubtree = isSubtree(p, q);

        System.out.println(isSubtree);
    }

    public static boolean isSubtree(TreeNode p, TreeNode q) {
        if (p == null) {
            return false;
        }
        if (q == null) {
            return true;
        }
        if (isIdentical(p, q)) {
            return true;
        }
        return isSubtree(p.left, q) || isSubtree(p.right, q);
    }

    public static boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
    }
}
