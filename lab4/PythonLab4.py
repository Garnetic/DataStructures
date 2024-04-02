class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def invertTree(root):
    if root is None:
        return None

    root.left, root.right = root.right, root.left

    invertTree(root.left)
    invertTree(root.right)

    return root

def printTree(root, depth):
    if root is None:
        return

    print("-> " * depth + str(root.val))
    printTree(root.left, depth + 1)
    printTree(root.right, depth + 1)

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(8)
root.left.left = TreeNode(3)
root.left.right = TreeNode(4)
root.right.left = TreeNode(5)
root.right.right = TreeNode(6)

print("Before:")
printTree(root, 0)
inverted = invertTree(root)
print("\nAfter:")
printTree(inverted, 0)
