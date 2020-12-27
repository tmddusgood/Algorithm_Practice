n, m = map(int, input("입력해주세요").split())

maximum = 0
for row in range(n):
    data = list(map(int, input().split()))
    tmp_min = min(data)
    maximum = max(tmp_min, maximum)

print(maximum)
