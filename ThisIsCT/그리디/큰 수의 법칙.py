n, m, k = map(int, input().split())
array = list(map(int, input().split()))

array_sorted = sorted(array, reverse = True)
countM = 0
countK = 0
sum_result = 0

#while문 안에 또 while문을 넣으면 조건이 이중으로 작용할까?
#가장 깊은 단계의 반복문에서는 그 while문의 조건만이 작용한다.
#내지는 for문이 안에 있다면 for문 실행 도중 while문의 조건을 만족해도 for문은 실행된다
#while문이 한 번 돌고 시작하기 전에 검사하는 것이기 때문에... 이것만 기억하면 당연한 것

#while문을 이용한다면...
# while (countM < m):
#     if countK < 3:
#         countM += 1
#         countK += 1
#         sum_result += array_sorted[0]
#     else:
#         countM += 1
#         countK = 0
#         sum_result += array_sorted[1]


for i in range(m):
    if countK < 3:
        countK += 1
        sum_result += array_sorted[0]
    else:
        countK = 0
        sum_result += array_sorted[1]

print(sum_result)