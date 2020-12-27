n, m = map(int, input().split())
count = 0
array = []
for i in range(m):
    array.append(list(map(int, input().split())))

print(array)

for i in range(n):
    for j in range(m):
        if array[n][m] != 1:
            count += 1

