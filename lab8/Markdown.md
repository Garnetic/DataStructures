# High-Level Approach(es)
- Create an array to store combinations of coins to add up to amount
- Fill the array with amount + 1 so as to have an impossible to reach amount in it
- Set the first in the array to 0
- Then iterate through the array
  - For each coin type
    - If the coin is less than or equal to amount
    - Then updatehe minimum coins needed for amount 'i' by comparing current coin
- Then if the amount isn't reachable return -1
- Otherwise return the amount of coins needed 
