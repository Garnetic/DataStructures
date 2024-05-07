public class JavaLab8 {
    public static void main(String[] args) {
        int[] coins1 = {1, 5, 10, 25, 50, 100};
        int[] coins2 = {1, 10, 25, 50, 100};

        System.out.println(coinChange(coins1, 40)); // Should be 3 since we have 5
        System.out.println(coinChange(coins2, 40)); // Should be 4 since we don't have 5
    }

    public static int coinChange(int[] coins, int amount) {

        // Initialize an array to store the smallest number of coins
        // needed for each amount from 0 to amount
        int[] array = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            // Fill the array with amount + 1, inf would also work
            array[i] = amount + 1;
        }

        array[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // For each coin provided:
            for (int coin : coins) {
                // If the coin is less than or equal to the current amount,
                if (coin <= i) {
                    // Then update the minimum coins needed for amount 'i' by comparing current coin.
                    array[i] = Math.min(array[i], array[i - coin] + 1);
                }
            }
        }

        // If the amount isn't reachable, return -1.
        if (array[amount] > amount) {
            return -1;
        }

        // Otherwise, return the number of coins :)
        return array[amount];
    }

}