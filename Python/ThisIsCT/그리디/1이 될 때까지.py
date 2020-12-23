# from time import time
#
#
# n, k = map(int, input().split())
#
#
# start_time = time()
# count = 0
# while n != 1:
#     if n % k == 0:
#         n /= k
#     elif n < k:
#         break
#     else:
#         n -= 1
#     count += 1
#
# count += (n - 1)
#
# end_time = time()
# print(count)
# print(end_time - start_time)


n, k = map(int, input().split())
count = 0

while n != 1:
    if n % k == 0:
        n = n / k
    else:
        n -= 1
    count += 1

print(count)




