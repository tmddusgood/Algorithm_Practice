from collections import deque

n, m = map(int, input().split())

miro = []
visited = [[0] * m for _ in range(n)]
for _ in range(n):
    miro.append(list(map(int, input())))
visited[0][0] = 1

dx = [1, 0, 0, -1]
dy = [0, 1, -1, 0]

def bfs(x, y):
    count = 0
    queue = deque()
    queue.append((x, y, count))

    while queue:
        x, y, count = queue.popleft()

        for _ in range(4):
            newX = x + dx[_]
            newY = y + dy[_]
            newCount = count + 1

            if newX < 0 or newY < 0 or newX >= m or newY >= n:
                continue

            if miro[newY][newX] == 0:
                continue

            if miro[newY][newX] == 1 and visited[newY][newX] == 0:
                visited[newY][newX] = 1
                queue.append((newX, newY, newCount))
                if newX == (m-1) and newY == (n-1):
                    print(newX, newY)
                    return newCount + 1




print(bfs(0, 0))