def main():
    # Read in the number you want to find
    n = int(input("Enter the nth value of the Fibonacci sequence you would like to find: "))

    # Edge case for the first two values
    if n == 1:
        print(0)
        return
    elif n == 2:
        print(1)
        return

    # For the rest, excluding the first two, find the value
    first, second = 0, 1
    print("1: 0\n2: 1")

    # n-2 since the first two are skipped
    for i in range(n - 2):
        # Calculate the next term
        first, second = second, first + second
        print(f"{i + 3}: {second}")

# Run the main function
if __name__ == "__main__":
    main()
