#[문제10872](https://acmicpc.net/problem/10872)
## 첫번째 풀이
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P10872 {
    static int factorial(int number){
        if(number == 1){
            return number;
        }
        else if(number == 0){
            return 1;
        }
        return number * factorial(number - 1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        System.out.println(factorial(number));
    }
}
~~~
* 마지막일 때 종료조건을 넣는 것까지는 좋았는데 0일 떄를 생각하지 않아서 한 번 틀렸다
* for문으로 만드는 것도 해봐야겠다.
* 이쯤오니 실은 가장 어려웠던 것은 BufferedReader, StringBuilder, StringTokenizer 등을 이해하는 것이었나 하는 생각이 든다..

##두번째 풀이
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10872_2 {

    private static int factorial(int number){
        int result = 1;
        for (int i = 0; i < number; i++){
            result *= (number - i);
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        System.out.println(factorial(number));
    }
}
~~~
* for문으로 실행했더니, 확실히 함수 수행속도가 빨라졌다. 숫자가 커지면 커질 수록 그 격차는 커질 것이다.