def solution(n, computers):
    networks = []
    networks_dict = {}
    computer_number = 0

    for computer in computers:
        temp = []
        number = 0
        for connected in computer:
            if connected == 1:
                temp.append(number)
            number += 1
            networks_dict[computer_number] = temp
        computer_number += 1

    print(networks_dict)

solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]])