# Matrix-List-Graph Extra Credit: High-Level Approach(es)

## List to Matrix conversion:
- Given an ArrayList of LinkedLists of Integers (Adjacency List)
- Create an Adjacency Matrix in the form of a 2D array of booleans
- For each vertex in the given ArrayList, iterate through it's LinkedLists of edges
- And if there is an edge, set the relative position (intersection of the two vertices) in the 2D array to True
- Then return the newly filled 2D array
