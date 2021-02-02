def solution(participant, completion):
    temp_dict = {}

    for _ in participant:
        if _ in temp_dict:
            temp_dict[_] += 1
        else:
            temp_dict[_] = 1

    for _ in completion:
        temp_dict[_] -= 1

    for _ in temp_dict:

        if temp_dict[_] != 0:
            answer = _

    return answer

solution(["leo", "kiki", "eden", 'leo'], ["eden", "kiki", 'leo'])