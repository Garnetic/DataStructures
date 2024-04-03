import javax.management.timer.TimerMBean;
import java.util.*;

public class JavaHw11 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) { // If there is nothing to change
            System.out.println("Color already set, no change");
            print(image);
            return image; // Don't change it
        }

        // Print out array before it's modified
        print(image);

        int preColor = image[sr][sc]; // The (target) color before the change

        Queue<int[]> queue = new LinkedList<>(); // Make queue for queuing
        queue.add(new int[] {sr, sc}); // Add this for while loop to start

        while (!queue.isEmpty()) { // While the queue isn't empty
            int[] current = queue.remove(); // Get the first position in the queue
            if (image[current[0]][current[1]] == preColor) { // If it's the target color
                image[current[0]][current[1]] = color; // set the current location to the color given

                // For each of the current location's neighbors that are not out of bound,
                // add them to the queue :)
                if (current[0] >= 1)
                    queue.add(new int[]{current[0] - 1, current[1]}); // Above
                if (current[0] + 1 < image.length)
                    queue.add(new int[]{current[0] + 1, current[1]}); // Below
                if (current[1] >= 1)
                    queue.add(new int[]{current[0], current[1] - 1}); // Left
                if (current[1] + 1 < image[0].length)
                    queue.add(new int[]{current[0], current[1] + 1}); // Right
            }
        }

        // Print out of the modified array
        print(image);
        return image; // Return the modified array
    }

    public static void print(int[][] array) {
        for (int[] ints : array) { // Loop through each row
            for (int anInt : ints) { // Loop through each column of the current row
                System.out.print(anInt + " "); // Print the element at the current row and column
            }
            System.out.println(); // Move to the next line after printing all columns of the current row
        }
        System.out.println(); // Extra line
    }

    public static void main(String[] args) {
        // Test case 1
        System.out.println("Test Case 1:");
        int[][] image1 = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        floodFill(image1, 1, 1, 2);

        // Test case 2
        System.out.println("Test Case 2:");
        int[][] image2 = {{0,0,0},
                          {0,0,0}};
        floodFill(image2, 0, 0 ,0);

        System.out.println("Test Case 3:");
        // Test case 3
        int[][] image3 = {{0,0,0},
                          {0,0,0}};
        floodFill(image3, 0, 0 ,1);

        // Test case 4
        System.out.println("Test Case 4:");
        int[][] image4 = {{1,1,1},
                          {1,0,1},
                          {1,1,1}};
        floodFill(image4, 0, 0, 2);
    }
}
