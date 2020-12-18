n, m = map(int, input().split())

graph = []
for _ in range(n):
    graph.append(list(map(int, input())))

visited = [[0]* m for _ in range(n)]
visited[0][0] = 1

def dfs(x, y):
    if x < 0 or y < 0 or x == n or y == m:
        return False
    if graph[x][y] == 0 and visited[x][y] == 0:
        visited[x][y] = 1
        dfs(x + 1, y)
        dfs(x, y + 1)
        dfs(x - 1, y)
        dfs(x, y - 1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True:
            result += 1

print(result)