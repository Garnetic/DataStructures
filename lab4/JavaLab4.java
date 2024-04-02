public class JavaLab4 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Before:");
        printTree(root, 0);
        TreeNode inverted = invertTree(root);
        System.out.println("\nAfter:");
        printTree(inverted, 0);
    }

    public static void printTree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        System.out.println("-> ".repeat(depth) + root.val);
        printTree(root.left, depth + 1);
        printTree(root.right, depth + 1);
    }

    //Lab 4
    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp;
        temp = root.left;

        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
