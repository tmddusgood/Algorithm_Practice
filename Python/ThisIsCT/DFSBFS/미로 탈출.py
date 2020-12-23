from collections import deque

n, m = map(int, input().split())

miro = []
for _ in range(n):
    miro.append(list(map(int, input())))

visited = [[0]*m for _ in range(n)]
visited[0][0] = 1

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def dfs(x, y, move):
    queue = deque()
    queue.append((x, y, move))

    while queue:
        x, y, move = queue.popleft()
        for _ in range(4):
            newX = x + dx[_]
            newY = y + dy[_]
            newMove = move + 1

            if newX < 0 or newY < 0  or newX >= n or newY >= m:
                continue

            if visited[newX][newY] == 1:
                continue

            if visited[newX][newY] == 0 and miro[newX][newY] == 1:
                queue.append((newX, newY, newMove))
                if newX == (n - 1) and newY == (m - 1):
                    return newMove + 1


print(dfs(0, 0, 0))
