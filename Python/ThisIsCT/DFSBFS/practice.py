from collections import deque

queue = deque()
queue.append(1)
queue.append(2)
value = queue.popleft()
print(queue, value)