#선택정렬

array = [1, 3, 5, 6, 10, 23, 45, 4, 7, 5, 2]

for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[j] < array[min_index]:
            min_index = j
    array[i], array[min_index] = array[min_index], array[i]

print(array)
