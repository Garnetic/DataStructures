class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def lowest_common_ancestor(root, p, q):
    # If both values are less than the current node, search the left subtree
    if root.val > p.val and root.val > q.val:
        return lowest_common_ancestor(root.left, p, q)

    # If both values are greater than the current node, search the right subtree
    if root.val < p.val and root.val < q.val:
        return lowest_common_ancestor(root.right, p, q)

    # Otherwise, this is the LCA
    return root

if __name__ == "__main__":
    # make the binary search tree
    root = TreeNode(4)
    three = root.left = TreeNode(3)
    eight = root.right = TreeNode(8)
    one = three.left = TreeNode(1)
    five = eight.left = TreeNode(5)
    nine = eight.right = TreeNode(9)

    # Test cases
    lca1 = lowest_common_ancestor(root, one, nine)
    print("LCA of 1 and 9:", lca1.val)  # Expected output: 4

    lca2 = lowest_common_ancestor(root, five, nine)
    print("LCA of 5 and 9:", lca2.val)  # Expected output: 8

    lca3 = lowest_common_ancestor(root, three, one)
    print("LCA of 3 and 1:", lca3.val)  # Expected output: 3

    lca4 = lowest_common_ancestor(root, one, five)
    print("LCA of 1 and 5:", lca4.val)  # Expected output: 4
