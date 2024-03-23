public class JavaHw9 {
    public static void main(String[] args) {
        // Make the binary tree from canvas
        TreeNode root = new TreeNode(4);
        TreeNode three = root.left = new TreeNode(3);
        TreeNode eight = root.right = new TreeNode(8);
        TreeNode one = root.left.left = new TreeNode(1);
        TreeNode five = root.right.left = new TreeNode(5);
        TreeNode nine = root.right.right = new TreeNode(9);

        // Test case: LCA of nodes 1 and 9
        TreeNode lca1 = lowestCommonAncestor(root, one, nine);
        System.out.println("LCA of 1 and 9: " + lca1.val); // Expected output: 4

        // Test case: LCA of nodes 5 and 9
        TreeNode lca2 = lowestCommonAncestor(root, five, nine);
        System.out.println("LCA of 5 and 9: " + lca2.val); // Expected output: 8

        // Test case: LCA of nodes 3 and 1
        TreeNode lca3 = lowestCommonAncestor(root, three, one);
        System.out.println("LCA of 3 and 1: " + lca3.val); // Expected output: 3

        // Test case: LCA of nodes 1 and 5
        TreeNode lca4 = lowestCommonAncestor(root, one, five);
        System.out.println("LCA of 1 and 5: " + lca4.val); // Expected output: 4
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Special edge case
        if (root == null || p == null || q == null) {
            return null;
        }

        // If the values are less than the current node (Starting at root)
        // Then look on the left side of the subtree
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, q, p);
        }

        // If the values are greater than the current node (Starting at root)
        // Then look on the right side of the subtree
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, q, p);
        }
        return root;
    }
}
