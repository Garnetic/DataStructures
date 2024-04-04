from collections import deque

def flood_fill(image, sr, sc, color):
    if not image or not image[0] or image[sr][sc] == color:
        print("No change needed")
        print_image(image)
        return image

    # Print out array before it's modified
    print_image(image)

    pre_color = image[sr][sc]
    queue = deque()
    queue.append((sr, sc))

    while queue:
        current = queue.popleft()
        if image[current[0]][current[1]] == pre_color:
            image[current[0]][current[1]] = color

            if current[0] >= 1:
                queue.append((current[0]-1, current[1]))
            if current[0] + 1 < len(image):
                queue.append((current[0]+1, current[1]))
            if current[1] >= 1:
                queue.append((current[0], current[1]-1))
            if current[1] + 1 < len(image[0]):
                queue.append((current[0], current[1]+1))

    # Print out of the modified array
    print_image(image)
    return image

def print_image(image):
    for row in image:
        print(' '.join(str(val) for val in row))
    print()  # Extra line for spacing

# Test cases
print("Test Case 1:")
image1 = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
flood_fill(image1, 1, 1, 2)

print("Test Case 2:")
image2 = [[0, 0, 0], [0, 0, 0]]
flood_fill(image2, 0, 0, 0)

print("Test Case 3:")
image3 = [[0, 0, 0], [0, 0, 0]]
flood_fill(image3, 0, 0, 1)

print("Test Case 4:")
image4 = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
flood_fill(image4, 0, 0, 2)

print("Test Case 5:")
image5 = []
flood_fill(image5, 0, 0, 2)
