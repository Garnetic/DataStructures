# High-Level Approach(es)
- Use a modified binary search
- Store the left, right, and middle indexes of the given array
- Have a while loop for while left is less than right
  - Update the middle to match between left and right
  - If the middle element of the array is 'Bad'
  - Then set right to the middle
  - Otherwise set left to middle + 1
- Eventually reach the 'middle' which is the index where the 'Bad' version is at, and return that version
