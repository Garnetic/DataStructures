def coin_change(coins, amount):
    # Initialize an array to store the smallest number of coins
    # needed for each amount from 0 to amount
    array = [float('inf')] * (amount + 1)
    array[0] = 0

    for i in range(1, amount + 1):
        for coin in coins:
            if coin <= i:
                array[i] = min(array[i], array[i - coin] + 1)

    # If the amount isn't reachable, return -1.
    if array[amount] > amount:
        return -1

    # Otherwise, return the number of coins :)
    return array[amount]

def main():
    coins1 = [1, 5, 10, 25, 50, 100]
    coins2 = [1, 10, 25, 50, 100]

    print(coin_change(coins1, 40))  # Should be 3 since we have 5
    print(coin_change(coins2, 40))  # Should be 4 since we don't have 5

if __name__ == "__main__":
    main()
