# High-level approach(es)

Steps:
- Create a Binary Search Tree (BST)
- Compare p & q to root and find which subtree the ancestor is in
- Search the subtree until the nodes are on seperate subtrees, or if root node

## Recurse
- Recurse through the tree to find p & q
# Condition(s)
- if p & q are on the same side of the tree, call the function on that subtree
- if p & q are not on the same side of the tree, then return the (current) root

## Iterate
- Iterate through the tree to find p & q
# Condition(s)
- if p & q are on the same side of the tree, iterate (move) to that subtree
- if p & q are not on the same side of the tree, return the current node
