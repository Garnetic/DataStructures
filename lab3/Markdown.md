# Lab 3 Analysis
## Problem 1:
- 10000000000n^(2) vs n^(3) -> n^(3) is bigger
- n^2 log(n) vs n(log(n))^(10) -> n^2 log(n) is bigger
- n^(logn) vs 2^sqrt(n) -> n^(logn) is bigger
- 2^(n) vs 2^(2n) -> 2^(2n) is bigger

## Problem 2:
- Best Case: O(1)
  - If it returns false on the first iteration
- Average Case: O(sqrt(n))
  - If it has to iterate until it finds the prime number, as it is almost never going to find it first iteration
- Worst Case: O(sqrt(n))
  -  If the usual iteration until finding the prime number, with the i * i <= n quickening the iterations
