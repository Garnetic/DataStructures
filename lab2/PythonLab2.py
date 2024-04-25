def isAnagram(s, t):
    if len(s) != len(t):
        return False

    # Create a dictionary to count the frequency of each character in s
    count_s = {}
    for char in s:
        if char in count_s:
            count_s[char] += 1
        else:
            count_s[char] = 1

    # Subtract the frequency of each character found in t from count_s
    for char in t:
        if char in count_s:
            count_s[char] -= 1
            if count_s[char] == 0:
                del count_s[char]
        else:
            return False

    # If count_s is empty, then t is an anagram of s
    return len(count_s) == 0

def main():
    # Two test cases to show functionality
    test1 = isAnagram("listen", "silent")
    print(f"Is 'silent' an anagram of 'listen'? {test1}")  # Expected: True

    test2 = isAnagram("hello", "world")
    print(f"Is 'world' an anagram of 'hello'? {test2}")  # Expected: False

if __name__ == "__main__":
    main()