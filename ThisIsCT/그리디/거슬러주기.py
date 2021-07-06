n = 5200
count = 0

coin_types = [500, 100, 50, 10]

for coin_type in coin_types:
    count += n // coin_type
    n = n % coin_type

print(count)
# 리스트에서 아이템을 꺼내는 순서가 대입된 차례대로
# 나머지 후의 나머지값을 꺼낼 때는 %를 이용할 수 있음
# 모든 각각의 연산을 한 줄 한 줄 대입할 게 아니라 요약할 수 있다
# 그리디의 예시이며, 더 작은 값의 조합이 나오기 전에 큰 값을 통해서 동전을 거슬러주지 않을 수 있다는 아이디어

