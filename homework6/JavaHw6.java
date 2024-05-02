import java.util.*;

public class JavaHw6 {

    public static void main(String[] args) {
        int[] nums1 = {0,1,1};
        System.out.println(threeSum(nums1)); // []

        int[] nums2 = {-5,0,5,10,-10,0};
        System.out.println(threeSum(nums2)); // [[-10, 0, 10], [-5, 0, 5]]

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Make sure there's something to compare
        if (nums == null || nums.length < 3) {
            return result;
        }

        // Sort the array using insertion sort
        insertionSort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Save the current left and right i's
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                // Check if the sum is 0
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) { // if it is then yay, add it to the list
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicates for j and k
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++; // Move j to the right
                } else {
                    k--; // Move k to the left
                }
            }
        }

        // Return the results :)
        return result;
    }

    public static void insertionSort(int[] nums) {
        // Insertion Sorting B)
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }

            nums[j + 1] = key;
        }
    }
}
