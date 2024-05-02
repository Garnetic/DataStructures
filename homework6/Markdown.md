# High-Level Approach(es)
- Create a LinkedList to return
- Base case make sure the array given is large enough for an output
- Sort the array for easier duplication skipping
- Iterate through the array skipping duplicates
  - Save the current left and right pointers of i
  - While the left pointer is less than the right pointer
    - If the sum of the right, left, and current are 0, add them to the LinkedList
    - Keep looping until all unique values that add up to 0
- Then return the LinkedList
  
