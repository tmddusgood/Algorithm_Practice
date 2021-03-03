#문제 1
>문제
> 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
>
>입력
>입력은 여러 개의 테스트 케이스로 이루어져 있다.
>
>각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
>
>입력의 마지막에는 0 두 개가 들어온다.
>
>출력
>각 테스트 케이스마다 A+B를 출력한다.

## 나의 풀이 1
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer strTkr = new StringTokenizer(bufferedReader.read());

            int numberA = Integer.parseInt(strTkr.nextToken());
            int numberB = Integer.parseInt(strTkr.nextToken());

            if (numberA == 0 && numberB == 0) {
                break;
            }
            else{
                System.out.println(numberA+numberB);
            }
        }
    }
}
~~~
* parseInt 를 쓴 것은 primitive Type으로 반환받기 위해서
* BufferedReader의 Readline은 개행까지 한 줄을 통째로 읽어오는 것인 건 아는데
* read는 int값을 반환한다라는 사실...! 그래서 쓰려면 받은 값에서 아스키코드를 빼게 한다거나 뭐 그래야 한다네. 몰랐다.
* 만약 int계산을 하지 않는다면 string builder를 쓸 수 있을 거 같은데 쓰는 쪽으로 다시 바꿔보고 싶다.

