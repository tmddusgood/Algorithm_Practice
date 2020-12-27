#다이나믹 프로그래밍의 2가지 방법

#예시 - 피보나치 수열
def fibo(x):
    if x == 1 or x == 2:
        return 1
    return fibo(x-1) + fibo(x-2)

print(fibo(35))
#재귀함수를 이용했을 경우의 문제점
#동일한 함수가 반복적으로 호출된다! -> 이미 답을 구한 적이 있는데 또 연산을 하고 있다. -> 메모리 낭비


#예시 - 피보나치 수열 by Top Down
d = [0] * 1000000

def fibo2(x):
    # 종료 조건
    if x  == 1 or x == 2:
        return 1

    if d[x] != 0:

        0
        return d[x]

    d[x] = fibo(x - 1) + fibo(x-2)
    return d[x]

print(fibo2(35))

#예시 - 피보나치 수열 by Bottom Top
d = [0] * 100
d[1] = 1
d[2] = 1
n = 99

for i in range(3, 100):
    d[i] = d[i - 1] + d[i - 2]

# print(d[n])

#의문점: 여기서는 bottom top이 훨씬 빠른 것 같은데,
#내 생각으로는 함수 호출이 반복문보다 훨씬 느려서 그런 게 아닌가 생각.. 차후 더 생각해보자

#메모이제이션 기법! 저장해놓는 것 자체를 그렇게 말한다.


