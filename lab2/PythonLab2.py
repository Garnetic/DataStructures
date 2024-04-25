def is_anagram(s, t):
    if len(s) != len(t):  # If they are not the same length, they're not anagrams
        return False

    # Create copies of the strings as lists for manipulation
    t_list = list(t)

    for char in s:
        if char in t_list:
            t_list.remove(char)  # Remove the character once it's matched
        else:
            return False  # If the character from s isn't in t, return False

    return len(t_list) == 0  # If all characters match and are removed, t_list should be empty

def main():
    s = "listen"
    t = "silent"

    result = is_anagram(s, t)
    print(f'Is "{t}" an anagram of "{s}"? {result}')

if __name__ == "__main__":
    main()
