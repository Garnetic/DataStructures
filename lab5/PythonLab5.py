class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def printTree(root, depth):
    if root is None:
        return
    print("-> " * depth + str(root.val))
    printTree(root.left, depth + 1)
    printTree(root.right, depth + 1)

def isValidBST(root):
    if root is None:
        return True
    if ((root.left is None or root.left.val <= root.val)
            and (root.right is None or root.right.val >= root.val)):
        return isValidBST(root.left) and isValidBST(root.right)
    return False

root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

printTree(root, 0)
print(isValidBST(root))  # True

root2 = TreeNode(4)
root2.left = TreeNode(3)
root2.right = TreeNode(8)
root2.left.left = TreeNode(1)
root2.right.left = TreeNode(17)
root2.right.right = TreeNode(9)

printTree(root2, 0)
print(isValidBST(root2))  # False