# High-Level Approach(es)
- Have a base case for if no intervals, then return 0 rooms needed
- Use insertion sort to sort the 2D array based on starting time
- Create a minimum heap using priority queue
- Add the first meeting to the heap
- Have a for loop iterate through the meeting times
  - If there isn't an overlap in times, reuse the room
  - Otherwise have a new room
 - Return the heap's size, which is the amount of rooms needed 
