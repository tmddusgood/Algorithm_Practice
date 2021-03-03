# 문제 1
>문제
> N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
>
>입력
>첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.
>
>출력
>출력형식과 같게 N*1부터 N*9까지 출력한다.

~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static class Multiplification {
        private void showResult(int number) {
            for (int j = 1; j < 10; j++) {
                System.out.println(number + " * " + j + " = " + number * j);

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strTkr = new StringTokenizer(bufferedReader.readLine());

        int numA = Integer.parseInt(strTkr.nextToken());
        Multiplification multiplification = new Multiplification();
        multiplification.showResult(numA);
    }
}
~~~
* 내부 클래스를 이용해서 계산하는 부분을 함수로 만들어보았다
    * 예상컨대, 메모리를 더 차지하고 (Main에 static 클래스를 만들었으므로)
    * 시간도 더 걸리지 않을까 생각한다.
    * 그리고 + 를 통해서 하는 부분은 concat과 stringbuilder 그리고 + 의 차이를 알아야 할 것 같아서 <br>question에 추가를 해야겠다.
    
