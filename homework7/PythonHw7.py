import heapq

def minMeetingRooms(intervals):
    # Base case if there are no meetings, no rooms are needed
    if not intervals:
        return 0

    # Sort the intervals based on start time
    intervals.sort(key=lambda x: x[0])

    # Initialize a min heap
    min_heap = []

    # Add the first meeting's end time to the min heap
    heapq.heappush(min_heap, intervals[0][1])

    # Iterate through the rest of the meetings
    for start, end in intervals[1:]:
        # If there isn't an overlap, reuse the room
        if start >= min_heap[0]:
            heapq.heappop(min_heap)

        # Add the current meeting's end time to the heap
        heapq.heappush(min_heap, end)

    # Return the size of the heap, which represents the number of rooms needed
    return len(min_heap)

# Test cases
test1 = [[0, 30], [5, 10], [15, 20]]
print(minMeetingRooms(test1))  # Output: 2

test2 = [[0, 1], [1, 2], [2, 3]]
print(minMeetingRooms(test2))  # Output: 1
