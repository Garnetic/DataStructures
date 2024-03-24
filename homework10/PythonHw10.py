class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def levelOrder(root):
    # Base Case
    if root is None:
        return []

    ordered = []
    queue = [root]

    while queue:
        lvlSize = len(queue)  # Get the size of the level
        currentLvl = []  # List to store current level's values

        for _ in range(lvlSize):
            node = queue.pop(0)  # Get the first node in the queue
            currentLvl.append(node.val)  # Add node value to the current level list

            # Add children to the queue if they exist
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)

        ordered.append(currentLvl)

    return ordered

root = TreeNode(4)
root.left = TreeNode(3)
root.right = TreeNode(8)
root.left.left = TreeNode(1)
root.right.left = TreeNode(5)
root.right.right = TreeNode(9)

print(levelOrder(root))
