def three_sum(nums):
    result = []

    # Make sure there's something to compare
    if not nums or len(nums) < 3:
        return result

    # Sort the array using insertion sort
    insertion_sort(nums)

    for i in range(len(nums) - 2):
        # Skip duplicates for 'i'
        if i > 0 and nums[i] == nums[i - 1]:
            continue

        # Save the current left and right indices
        j = i + 1
        k = len(nums) - 1

        while j < k:
            sum_value = nums[i] + nums[j] + nums[k]

            if sum_value == 0:
                result.append([nums[i], nums[j], nums[k]])

                # Skip duplicates for j and k
                while j < k and nums[j] == nums[j + 1]:
                    j += 1
                while j < k and nums[k] == nums[k - 1]:
                    k -= 1

                j += 1
                k -= 1
            elif sum_value < 0:
                j += 1
            else:
                k -= 1

    return result

def insertion_sort(nums):
    for i in range(1, len(nums)):
        key = nums[i]
        j = i - 1

        while j >= 0 and nums[j] > key:
            nums[j + 1] = nums[j]
            j -= 1

        nums[j + 1] = key

def main():
    nums1 = [0, 1, 1]
    print(three_sum(nums1))  # []

    nums2 = [-5, 0, 5, 10, -10, 0]
    print(three_sum(nums2))  # [[-10, 0, 10], [-5, 0, 5]]

if __name__ == "__main__":
    main()
