n = int(input())

#여기서 굳이 30001을 하는 이유는.. 그냥 dpTable[정수]할 때 1더하고 빼고 없이 바로 구하려고 직관적으로
dpTable = [0] * 30001
#dpTable[1] = 0

for i in range(2, n + 1):
    dpTable[i] = dpTable[i - 1] + 1

    if i % 2 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 2] + 1)
    if i % 3 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 3] + 1)
    if i % 5 == 0:
        dpTable[i] = min(dpTable[i], dpTable[i // 5] + 1)

print(dpTable[n])

