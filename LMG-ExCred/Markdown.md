# Matrix-List-Graph Extra Credit: High-Level Approach(es)

## List to Matrix conversion:
- Given an ArrayList of LinkedLists of Integers (Adjacency List)
- Create an Adjacency Matrix in the form of a 2D array of booleans
- For each vertex in the given ArrayList, iterate through it's LinkedLists of edges
  - And if there is an edge, set the relative position (intersection of the two vertices) in the 2D array to True
- Then return the newly filled 2D array

## Matrix to List conversion:
- Given an 2D array of booleans (Adjacency Matrix)
- Create an Adjacency List in the form of an ArrayList of LinkedLists of Integers
- For each column of the 2D array, create a LinkedList of Integers to put edges in
  - And for each row of the 2D array, if the current position (of the row[j]) is true,
    - Then add the edge to the LinkedList of edges
  - Then add the LinkedList to the ArrayList
- Then return the newly filled ArrayList of LinkedLists of Integers
