from collections import deque

def solution(bridge_length, weight, truck_weights):
    queue = deque()
    queue.extend(truck_weights)
    time = 0
    onWeight = []

    while(queue):
        truck = queue.popleft()
        if sum(onWeight) + truck <= weight:
            onWeight.append(truck)
            time += 1
        else:
            time += 1
            onWeight

    answer = 0
    return answer

bridge_length = 2
weight = 10
truck_weights = [7, 4, 5, 6]

print(solution(bridge_length, weight, truck_weights))