# High-Level Approach(es)
- Create 2D array (matrix)
- Check if the color that's being changed is already the right color
- If so, then return the 2D array back
- Save the color that was initially  at the given spot
- Create a queue for storing locations
- Store the first given location into the queue
## Iterate
- While the queue is not empty
- - Remove the first location in the queue and save it in a variable
  - If the color at the saved variable is the color that was saved
  - Then add it to the queue
  - Then add it's neighbors that are not out of bounds to the queue
- Once queue is emptied, while loop stops and returns modified array matrix
