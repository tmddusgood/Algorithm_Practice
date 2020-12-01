import copy


def solution(n, lost, reserve):
    used = []
    dict = {}

    trash = []

    for lost_ in lost:
        if lost_ in reserve:
            trash.append(lost_)

    for trash_ in trash:
        lost.remove(trash_)
        reserve.remove(trash_)


    for lost_ in lost:
        temp = []
        if lost_ in reserve:
            reserve.remove(lost_)
        for reserve_ in reserve:
            if abs(reserve_ - lost_) <= 1:
                temp.append(reserve_)
                dict[lost_] = temp

    print(dict)

    for item in dict:
        temp = dict[item]
        for temp_ in temp:
            if not temp_ in used:
                used.append(temp_)
                break

    answer = len(used) + n - len(lost)
    print(answer)

solution(5, [1, 2, 4], [1, 2, 4])

