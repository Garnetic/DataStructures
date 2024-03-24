# High-Level Approach(es)
Steps:
- Create Tree
- recurse through tree, putting node values in a list
- put that list in another list
## Iterate
- If the root is null, return null
- Create list of lists to return
- Create queue to use Breadth-First-Search (BFS)
- Create a while loop to iterate through the tree while the queue isn't empty
- - Create list to put in other list of lists
- - Create for loop to put nodes in list to put in another list
- - Get the first node in the queue (starting with root)
- - Add said node to list to be put in other list
- - Whichever children of first node aren't null, add them to queue (to be put in the list)
- Add newly made list into list of lists
- return the list of lists 
