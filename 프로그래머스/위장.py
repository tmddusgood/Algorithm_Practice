def solution(clothes):
    clothes_dict = {}

    for clothe in clothes:
        temp_type = clothe[1]
        if temp_type not in clothes_dict:
            clothes_dict[temp_type] = 1
        else:
            clothes_dict[temp_type] += 1

    count = 1

    for i in clothes_dict:
        count = count * (clothes_dict[i] + 1)

    answer = count - 1
    return answer

clothes = [["모자", "헤드기어"], ["안경", "얼굴"], ["선글라스", "얼굴"]]
print(solution(clothes))