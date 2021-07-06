def solution(numbers, target):
    result = []

    for number in numbers:
        print(number)
        temp = []
        for item in result:
            temp.append(item + number)
            temp.append(item - number)
        result = temp
        print(temp)

    answer = result.count(3)
    return answer


numbers = [1, 2, 3]
target = 3

print(solution(numbers, target))