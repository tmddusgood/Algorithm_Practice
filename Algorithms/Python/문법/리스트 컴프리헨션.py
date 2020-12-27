# list.append()를 사용했던 지금까지의 안타까운 나날을 돌이켜보며... ㅠㅠ
# 분명 java에서도 내가 바보같이 사용했던 부분이 있을 것이다 외주 프로젝트에서 조차!
# 다만 deep copy 의 문제로 생기는 문제는 없었을 것.. 일일히 다 append() 했었기 때문

array = [i for i in range(20) if i % 2 != 0]
print(array)

array = [i for i in range(1, 10)]
print(array)

dict = {}
dict[1] = 2
print(dict)
del dict[1]
print(dict)

n = 5
m = 4
array = [[n*m]*m for _ in range(n)]
print(array)

n = 5
m = 4
array = [0 * n for _ in range(m)]
print(array)

n = 5
m = 4
array = [[0] * n for _ in range(m)]
print(array)

#리스트 컴프리헨션을 사용하지 않았을 경우, 주소를 복사해서 행렬이 만들어지기 때문에
# 아래와 같은 초기화를 했을 경우 동일항 행이 복사되는 .
# 케이스가 발생할 수 있다.

array[1][1] = 5
print(array)

array = [0 for i in range(1, 11) if i % 2 != 1]
print(array)

print(array[1:-1])

