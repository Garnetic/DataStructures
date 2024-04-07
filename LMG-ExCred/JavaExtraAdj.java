import java.util.*;

public class JavaExtraAdj {
    public static void main(String[] args) {
        // Create an Adjacency List
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>();
        adjList.add(new LinkedList<>(List.of(1, 2))); // 0: -> 1 -> 2
        adjList.add(new LinkedList<>(List.of(0, 2))); // 1: -> 0 -> 2
        adjList.add(new LinkedList<>(List.of(0, 1))); // 2: -> 0 -> 1

        System.out.println("List to Matrix:");
        printList(adjList); // Print out the list given
        printMatrix(listToMatrix(adjList)); // Print out the returned matrix

        // Create an Adjacency Matrix
        // Same connections as the adjList                -  0 1 2
        boolean[][] adjMatrix = {{false, true, true},  // 0: F T T
                                 {true, false, true},  // 1: T F T
                                 {true, true, false}}; // 2: T T F

        System.out.println("\nMatrix to List:");
        printMatrix(adjMatrix); // Print out the matrix given
        printList(matrixToList(adjMatrix)); // Print out the returned list

        // Edge Reversing:
        Graph graph = new Graph(5); // Create a graph with 5 vertices
        // Add edges between vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("\nGraph Reversal:");
        printList(graph.getAdjList()); // Print out the list before reversed
        graph.setAdjList(graph.reverseEdges().getAdjList()); // Reverse the edges
        printList(graph.getAdjList()); // Print out the list after reversed
        graph.setAdjList(graph.reverseEdges().getAdjList()); // Reverse the edges again
        printList(graph.getAdjList()); // Print out the list after reversed again
    }

    // Given an adjacency list, change it into an adjacency matrix
    // Returns an adjacency matrix in a 2D array form
    // Assume I'm given the list to change
    public static boolean[][] listToMatrix(ArrayList<LinkedList<Integer>> adjList) {
        int vertices = adjList.size();
        boolean[][] adjMatrix = new boolean[vertices][vertices]; // Make a adjMatrix to fill and return

        for (int i = 0; i < vertices; i++) { // For each vertex in the adjList
            for (int j : adjList.get(i)) { // Iterate through it's list of attached vertices
                adjMatrix[i][j] = true; // And set the intersection of two vertices as true in the matrix
            }
        }
        // Return newly made adjacency matrix :)
        return adjMatrix;
    }

    // Given an adjacency matrix, change it into an adjacency list
    // Returns an adjacency list in an arraylist of integer lists form
    // Assume I'm given the matrix to change
    public static ArrayList<LinkedList<Integer>> matrixToList(boolean[][] adjMatrix) {
        ArrayList<LinkedList<Integer>> adjList = new ArrayList<>(); // Make an adjList to fill and return

        for (boolean[] matrix : adjMatrix) { // For each column of the adjMatrix
            LinkedList<Integer> adj = new LinkedList<>(); // Create a list of integers to put edges in
            for (int j = 0; j < adjMatrix.length; j++) { // And for each row of the adjMatrix
                if (matrix[j]) { // If there is a connection (since it's a boolean) at the current location
                    adj.add(j); // Add that connection to the adjList
                }
            }
            adjList.add(adj); // Then add that list to the arraylist
        }
        // Return the newly made adjacency list :)
        return adjList;
    }

    // Function for printing out Adjacency Lists
    public static void printList(ArrayList<LinkedList<Integer>> adjList) {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + ":");
            for (int vertex : adjList.get(i)) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }

    // Function for printing out Adjacency Matrices
    public static void printMatrix(boolean[][] matrix) {
        System.out.println("Adjacency Matrix:");
        for (boolean[] row : matrix) {
            for (boolean cell : row) {
                System.out.print((cell ? "T" : "F") + " ");
            }
            System.out.println();
        }
    }

    // Inverting edges in a graph:
    private static class Graph { // Create a private class for graphing
        private ArrayList<LinkedList<Integer>> adjList; // Give it its own adjList :)
        private final int vertices; // As well as the number of total vertices

        // Constructor
        // This is straightforward
        public Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>();
            for (int i = 0; i < vertices; i++) { // For each vertex
                adjList.add(new LinkedList<>()); // Create a linkedlist and add it to the arraylist
            }
        }

        // Function to add an edge from u to v
        public void addEdge(int u, int v) {
            adjList.get(u).add(v); // Just a generic add edge to the adjList, directed of course
        }

        // Function to reverse all edges
        public Graph reverseEdges() {
            Graph reversedGraph = new Graph(vertices); // Create a new graph to copy reversed edges into
            for (int u = 0; u < vertices; u++) { // For each edge "u"
                for (int v : adjList.get(u)) { // Get what edge "u" is pointing to from the adjLust
                    // And add an edge from the edge that's being pointed at "v"
                    // From "v" to "u" into the new graph
                    reversedGraph.addEdge(v, u);
                }
            }
            // Then return the newly made reversed graph :)
            return reversedGraph;
        }

        // Getter for main access
        public ArrayList<LinkedList<Integer>> getAdjList() {
            return adjList;
        }

        // Setter for main access
        public void setAdjList(ArrayList<LinkedList<Integer>> adjList) {
            this.adjList = adjList;
        }
    }
}
