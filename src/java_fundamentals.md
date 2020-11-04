## 숫자 자료형 (int, long, float, double)
### int vs long
* int 범위가 더 작지만, 연산 속도가 더 빠르다
* 꼭 필요한 경우에만 long 쓰자
### float vs double
* 정확도 자체는 double이 더 높다
* 둘 다 느리니까 double 쓰자.
### Overflow (리터럴)
~~~
long a = 10000000 * 100000; // int * int -> int
System.out.println(a);
>>> -727379968

long b = 10000000L * 100000; // long * int -> long
System.out.println(b);
>>> 1000000000000

double a = 3 / 2;
System.out.println(a); // 소수점 이하 버림 발생
>>> 1.0

double b = 3 / 2.0
System.out.print(b); 
>>> 1.5

double c = 3f / 2;
System.out.println(c);
>>> 1.5
~~~
* 리터럴의 기본현은 int 형이다.
* 연산의 결과가 소수점을 포함하려면 .0이나 f를 붙여주어야 한다.