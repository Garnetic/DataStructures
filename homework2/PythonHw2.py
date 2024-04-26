def isBadVersion(version):
    return version % 2 == 1


def versionFinder(versions):
    left = 1
    right = len(versions) - 1

    while left < right:
        mid = left + (right - left) // 2
        if isBadVersion(versions[mid]):
            right = mid
        else:
            left = mid + 1

    return versions[left]


def main():
    v1 = [2, 4, 3, 3, 1, 11]
    print(versionFinder(v1))

    v2 = [6, 2, 4, 7, 9, 11]
    print(versionFinder(v2))

    v3 = [2, 8, 6, 9, 7, 11, 13]
    print(versionFinder(v3))


if __name__ == "__main__":
    main()