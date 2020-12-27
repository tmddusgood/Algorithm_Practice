# 리스트에서 pop을 사용하는 것은 추천하지 않는다고 한다.
from queue import Queue

que = Queue()
for _ in range(10):
    que.put(_)

que.put(11)

for _ in range(10):
    print(que.get())
