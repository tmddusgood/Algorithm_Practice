## 자료형
### Primitive Type vs Reference Type (Using Wrapper Class)
* Primitive Type 의 속도가 월등히 빠르다.
* Generic 에는 Primitive Type 사용이 불가하다.

### Generic 에서의 Primitive Type vs Reference Type
#### Primitive Type Array
~~~
ArrayDeque<Integer> deque1 = new ArrayDeque<>();
deque1.add("qwer");
deque1.add(1); 
deque1.add('b'); 

for (Object o : deque1){
    int x = (int)o; // String -> int 변환에서 에러가 발생한다.
    System.out.println(x);
}
~~~
* 런타임 에러가 발생한다.
#### Generic using Reference Type
~~~
ArrayDeque<Integer> deque2 = new ArrayDeque<>();
deque2.add("qwer"); // Syntax Error
deque2.add(1); // CORRECT
deque2.add('b'); // Syntax Error

for (Object o : deque1){
    int x = (int)o; 
    System.out.println(x);
}
~~~
* Syntax 에러를 통해서 컴파일 이전에 에러가 있음을 알 수 있다.
* 프로그램 실행 자체가 불가능하다.

