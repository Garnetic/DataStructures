import java.util.*;
public class JavaLab6 {
    public static void main(String[] args) {
        int[][] pre1 = {{1,0}};
        System.out.println(canFinish(2, pre1));

        int[][] pre2 = {{1,0},{0,1}};
        System.out.println(canFinish(2, pre2));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create array of number of in-degrees per node
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        // Have a for loop to fill the adjList
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Have a for loop to fill in the in-degree array and adjList
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adjList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Create a queue for storing vertices with 0 in-degrees
        Queue<Integer> queue = new LinkedList<>();
        // Have a for loop to fill the queue with 0 in-degrees
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Make a counter to compare size later on
        int count = 0;
        // Make a loop while the queue isn't empty
        while (!queue.isEmpty()) {
            // Get the first 0-indegree vertex from the queue
            int current = queue.remove();
            // Increment the count
            count++;

            // Iterate through the given 2D array
            for (int i : adjList.get(current)) {
                // Decrement the indegree at the current location
                indegree[i]--;
                // If it becomes 0, then add it to the queue
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }
        // Finally, return if the size of the arraylist is equal to the given num
        return count == numCourses;
    }
}