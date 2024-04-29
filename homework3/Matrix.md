# Matrix-Multiply Time Analysis
- A for loop to iterate through A's Rows - O(n) runtime
  - A nested for loop to iterate through B's Columns - O(m) runtime
    - Another nested for loop to iterate through A's Columns - O(p) runtime
- With these three for loops, the runtime is n * m * p or O(mnp) 
