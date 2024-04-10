from collections import deque

def canFinish(numCourses, prerequisites):
    indegree = [0] * numCourses
    adjList = [[] for _ in range(numCourses)]

    for pre in prerequisites:
        indegree[pre[0]] += 1
        adjList[pre[1]].append(pre[0])

    queue = deque([i for i in range(numCourses) if indegree[i] == 0])

    count = 0
    while queue:
        current = queue.popleft()
        count += 1

        for i in adjList[current]:
            indegree[i] -= 1
            if indegree[i] == 0:
                queue.append(i)

    return count == numCourses

# Test cases
pre1 = [[1, 0]]
print(canFinish(2, pre1))

pre2 = [[1, 0], [0, 1]]
print(canFinish(2, pre2))