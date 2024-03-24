import java.util.*;

public class JavaHw10 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // Base Case
        if (root == null) {
            return null;
        }

        // Make the list
        List<List<Integer>> ordered = new ArrayList<>();

        // Breadth First Search (BFS)
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        // while loop for vertical
        while (!queue.isEmpty()) {
            int lvlSize = queue.size(); // get the size
            List<Integer> currentLvl = new ArrayList<>(); // make a list for this level
            // For loop for horizontal
            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = queue.remove(); // make the current node the first in the queue
                currentLvl.add(node.val); // add node to list

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ordered.add(currentLvl);
        }
        return ordered;
    }
}
