n = int(input())

count = 0

for k in range(int(n) + 1):
    for i in range(60):
        for j in range(60):
            string = str(k) + str(i) + str(j)
            if '3' in string:
                count += 1

print(count)