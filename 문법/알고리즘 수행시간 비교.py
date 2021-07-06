import time
from random import randint

array = []
for _i in range(10000):
    array.append(randint(1,100))

start_time = time.time()

for i in range(len(array)):
    min_index = i
    for j in range(i+1, len(array)):
        if array[min_index] > array[j]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]

end_time = time.time()
print("my algorithm: ", (end_time - start_time))

array = []
for _i in range(10000):
    array.append(randint(1,100))

start_time = time.time()

array.sort()

end_time = time.time()

print("library time: ", (end_time - start_time))


