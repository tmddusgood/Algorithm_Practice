n = int(input())

dpTable = [0] * 30000

for i in range(1, n+1):
    number = i
    count = 0
    while True:
        if i == 1:
            break

        if i % 5 == 0 and i / 5 > 0:
            count += 1
            i = i / 5
        elif i % 3 == 0 and i / 5 > 0 :
            count += 1
            i = i / 3
        elif i % 2 == 0 and i / 2 > 0 :
            count += 1
            i = i / 2
        else:
            count += 1
            i -= 1

    dpTable[number] = count
    print(number, count)



