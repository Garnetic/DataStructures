public class JavaLab5 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        printTree(root, 0);
        System.out.println(isValidBST(root)); // true

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(1);
        root2.right.left = new TreeNode(17);
        root2.right.right = new TreeNode(9);

        printTree(root2, 0);
        System.out.println(isValidBST(root2)); // false
    }

    public static void printTree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        System.out.println("-> ".repeat(depth) + root.val);
        printTree(root.left, depth + 1);
        printTree(root.right, depth + 1);
    }

    // lab 5
    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if ((root.left == null || root.left.val <= root.val)
                && (root.right == null || root.right.val >= root.val)) {
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }
}