from typing import List

def main():
    # Test Case 1: Given test case
    wells1 = [1, 1]
    pipes1 = [[1, 2, 1], [1, 2, 2]]
    print(minCostToSupplyWater(2, wells1, pipes1))  # Should be 2

    # Test Case 3: Pipe is cheaper
    wells2 = [10, 20, 30]
    pipes2 = [[1, 2, 5], [2, 3, 5], [1, 3, 20]]
    print(minCostToSupplyWater(3, wells2, pipes2))  # Should 20

    # Test Case 4: Cheap pipe tiebreak
    wells3 = [50, 50, 50, 50]
    pipes3 = [[1, 2, 10], [2, 3, 10], [3, 4, 10], [1, 3, 30]]
    print(minCostToSupplyWater(4, wells3, pipes3))  # Should be 80


def minCostToSupplyWater(n: int, wells: List[int], pipes: List[List[int]]) -> int:
    edges = []

    # Add edges for each 'well' to the list (well is n size)
    for i in range(n):
        # Connect the hinted 'virtual' node to each house
        # With the cost of building the well
        edges.append([0, i + 1, wells[i]])

    # Add the pipes to the list of edges
    edges.extend(pipes)

    # Sort the list of edges using quicksort
    edges.sort(key=lambda x: x[2])

    # Array to keep track of connected nodes, with each node as its own parent
    parent = [i for i in range(n + 1)]

    cost = 0
    count = 0

    # Iterate through all edges (now sorted)
    for edge in edges:
        i, j, k = edge

        # Use the find structure to check if the current edge forms a cycle.
        if find(parent, i) != find(parent, j):
            union(parent, i, j)  # Union the components if no cycle is formed.
            cost += k  # Add the cost of this edge to the total cost.
            count += 1  # Increment the count of edges included in the MST.

            # If we have included enough edges to connect all nodes, break out of the loop.
            if count == n:
                break

    # Return the minimum total cost to supply water to all houses.
    return cost


def find(parent, i):
    if parent[i] != i:
        parent[i] = find(parent, parent[i])
    return parent[i]


def union(parent, i, j):
    root_i = find(parent, i)
    root_j = find(parent, j)
    if root_i != root_j:
        parent[root_i] = root_j


if __name__ == "__main__":
    main()