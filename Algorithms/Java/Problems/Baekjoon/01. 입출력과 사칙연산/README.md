#문제
> Hello World!를 출력하시오.

#풀이
~~~java
public class Main {
	public static void main(String[] args) {
        System.out.println("Hello World!");
	}
}
~~~

#문제
> 강한친구 대한육군 을 한 줄에 한 번씩 출력..한다?

#풀이
~~~java
public class Main {
	public static void main(String[] args) {
        System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");
	}
}
~~~

#문제
~~~
/*
> \    /\
)  ( ')
(  /  )
\(__)| 
를 출력한다
*/
~~~

~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
}
~~~
* "\\" 를 쓰고 싶다면 백슬래시를 2번 쳐야 한다.
* []를 붙이면 문자 그대로 인식하는 경우가 있따
* 다른 특수 문자의 경우 \\를 붙이거나 하는 식으로 해결한다.
* 특수 문자를 입력하는 방식을 알게 되는 문제