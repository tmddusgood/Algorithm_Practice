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
   
## 문제 1 - 두번째 풀이 
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strTkr = new StringTokenizer(bufferedReader.readLine());

        int number = Integer.parseInt(strTkr.nextToken());
        for (int i = 1; i < 10; i ++){
            System.out.println(number + " * " + i + " = " + number * i);
        }
    }
}
~~~
* 의외로 메모리는 12kb 밖에 차이가 나지 않았다
* 그리고 시간에 있어서도 큰 차이가 나지 않았다
* 수십만 건에 대한 반복작업을 하는 것이 아니라면, 단 건이라면 모듈화를 시키는 것이 낫겠다는 생각을 한다.

# [문제 11022](https://www.acmicpc.net/problem/11022)
## 첫번째 풀이
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static StringBuilder buildString(int caseNumber, StringTokenizer stringTokenizer) {
    StringBuilder stringBuilder = new StringBuilder();
    int numA = Integer.parseInt(stringTokenizer.nextToken());
    int numB = Integer.parseInt(stringTokenizer.nextToken());

    return stringBuilder
            .append("Case #")
            .append(caseNumber)
            .append(": ")
            .append(numA)
            .append(" + ")
            .append(numB)
            .append(" = ")
            .append(numA + numB)
            .append("\n");
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder stringBuilder = new StringBuilder();
    StringTokenizer stringTokenizer;

    int caseCount = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < caseCount; i++) {
      stringTokenizer = new StringTokenizer(bufferedReader.readLine());
      stringBuilder = stringBuilder.append(buildString(i + 1, stringTokenizer));
    }

    System.out.println(stringBuilder);
  }
}
~~~
* 이 정도는 그냥 메인함수에 쓰는 게 함수 호출 면에서 (예를 들면 테스트케이스가 100만개라면??) 나을 수 있겠다.

## 두번째 풀이
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int caseCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < caseCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int numA = Integer.parseInt(stringTokenizer.nextToken());
            int numB = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder
                    .append("Case #")
                    .append(i + 1)
                    .append(": ")
                    .append(numA)
                    .append(" + ")
                    .append(numB)
                    .append(" = ")
                    .append(numA + numB)
                    .append("\n");
        }

        System.out.println(stringBuilder);
    }
}
~~~
* 실제로 메모리와 시간에서 미세하지만 차이가 있음을 알았다.
* 데이터가 많아진다면 그것이 유효한 개발에서의 차이가 될 수 있겠다
* 다만 클린 코드의 관점에서는 적절하지 않은 것 같다.