import java.util.*;

public class JavaHw12 {

    public static void main(String[] args) {
        // Test Case 1: Given test case
        int[] wells1 = {1,1};
        int[][] pipes1 = {{1,2,1},{1,2,2}};
        System.out.println(minCostToSupplyWater(2, wells1, pipes1)); // Should be 2

        // Test Case 3: Pipe is cheaper
        int[] wells2 = {10, 20, 30};
        int[][] pipes2 = {{1, 2, 5}, {2, 3, 5}, {1, 3, 20}};
        System.out.println(minCostToSupplyWater(3, wells2, pipes2)); // Should 20

        // Test Case 4: Cheap pipe tiebreak
        int[] wells3 = {50, 50, 50, 50};
        int[][] pipes3 = {{1, 2, 10}, {2, 3, 10}, {3, 4, 10}, {1, 3, 30}};
        System.out.println(minCostToSupplyWater(4, wells3, pipes3)); // Should be 80

    }

    // n houses
    // well.length == n
    // wells[i - 1] (at houses number 'i' is the individual cost of its own well)
    // pipes[j] = [house1_j, house2_j, cost_j]
    // represents the cost to connect house1_j and house2_j together using a pipe.
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Turn the given data into a graph (nicer to deal with)
        ArrayList<int[]> edges = new ArrayList<>();

        // Add edges for each 'well' to the list (well is n size)
        for (int i = 0; i < n; i++) {
            // Connect the hinted 'virtual' node to each house
            // With the cost of building the well
            edges.add(new int[] {0, i + 1, wells[i]});
        }

        // Add the pipes to the list of edges
        edges.addAll(Arrays.asList(pipes));

        // Convert to array for sorting
        int[][] edgesArr = edges.toArray(new int[0][]);

        // Sort the list of edges using quicksort over the entire range
        quickSort(edgesArr, 0, edgesArr.length - 1);

        // Array to keep track of connected nodes, with each node as its own parent
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        int cost = 0;
        int count = 0;

        // Iterate through all edges (now sorted)
        for (int[] edge : edgesArr) {
            int i = edge[0];   // From edge
            int j = edge[1];   // To edge
            int k = edge[2];   // For the cost of the edge

            // Use the find structure to check if the current edge forms a cycle.
            if (find(parent, i) != find(parent, j)) {
                union(parent, i, j);  // Union the components if no cycle is formed.
                cost += k;            // Add the cost of this edge to the total cost.
                count++;              // Increment the count of edges included in the MST.

                // If we have included enough edges to connect all nodes, break out of the loop.
                if (count == n) break;
            }
        }

        // Return the minimum total cost to supply water to all houses.
        return cost;
    }

    private static void quickSort(int[][] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    // Partition function for quicksort
    private static int partition(int[][] array, int low, int high) {
        int pivot = array[high][2];  // Take the last element as pivot
        int i = low - 1;  // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j][2] < pivot) {
                i++;

                // Swap array[i] and array[j]
                int[] temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i+1] and array[high] (or pivot)
        int[] temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }


    // Find for finding the set of the node 'i'
    private static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    // Union for adding an edge to the MST
    private static void union(int[] parent, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
