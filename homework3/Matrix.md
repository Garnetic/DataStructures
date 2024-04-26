# Matrix-Multiply Time Analysis
- A for loop to iterate through A's Rows - O(n) runtime
  - A nested for loop to iterate through B's Columns - O(n) runtime
    - Another nested for loop to iterate through A's Columns - O(n) runtime
- With these three for loops, the runtime is n * n * n or O(n^3) 
