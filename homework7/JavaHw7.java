import java.util.*;

public class JavaHw7 {
    public static void main(String[] args) {
        int[][] test1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(test1));

        int[][] test2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(minMeetingRooms(test2));
    }

    public static int minMeetingRooms(int[][] intervals) {
        // Base case if there are no meetings, no rooms are needed
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Insertion sort the 2D array ordered by start time
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int j = i - 1;
            while (j >= 0 && intervals[j][0] > current[0]) {
                intervals[j + 1] = intervals[j];
                j--;
            }
            intervals[j + 1] = current;
        }

        // Create a min heap using a priority queue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length);

        // Add the first meeting's end to the min heap
        minHeap.add(intervals[0][1]);

        // Have a for loop to iterate through the rest of the meetings
        for (int i = 1; i < intervals.length; i++) {
            // If there isn't an overlap, reuse the room
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.remove();
            }
            // Still add the next meeting to the heap
            minHeap.add(intervals[i][0]);
        }

        // Return size of meetings
        return minHeap.size();
    }
}
