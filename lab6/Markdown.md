# High-Level Approach(es)
## Use (a slightly modified) Khan's Algorithm
- Create a array to store indegree count
- Create an adjacency list to store adjacent vertices
- Have a for loop fill the list with lists to later fill
- Have a for loop fill the array of indegrees, as well as fill the lists in the adjList
- Create a queue to temporarily store vertices with 0 indegrees
- Have a for loop iterate through the array of indegrees, adding the vertices with 0 to the queue
- Create a counter variable, set at 0
- Have a loop while the queue isn't empty
  - Grab the current front of the queue
  - Increment the counter
  - Then have a for loop iterate through the current
    - Decrement the indegree in the array for the current vertex (i)
    - If the current vertex then has 0 indegrees, add it to the queue
- Then once the queue is empty
- Return true if the counter is equal to the number of courses, otherwise false
