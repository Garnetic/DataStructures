import java.util.Scanner;

public class JavaExtraFibonacci {
    public static void main(String[] args) {
        // Read in the number you want to find
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the nth value of fibonacci you would like to find: ");
        int n = scanner.nextInt(); // nth number you want

        // Edge case for first two values
        if (n == 1) {
            System.out.println(0);
            return;
        } else if (n == 2) {
            System.out.println(1);
            return;
        }

        // For the rest, excluding first two, find the value
        int first = 0;
        int second = 1;
        int temp;
        // Print first two
        System.out.println("1: " + 0 + "\n2: " + 1);
        for (int i = 0; i < n - 2; i++) { // n - 2 since the first two are skipped
            // Calculate the next term
            temp = second;
            second = first + second;
            first = temp;
            // Print out the rest up the nth value
            System.out.println((i + 3) +": " + second);
        }
    }
}
