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


## 나의 풀이 2
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            StringTokenizer strTkr = new StringTokenizer(bufferedReader.readLine());

            int numberA = Integer.parseInt(strTkr.nextToken());
            int numberB = Integer.parseInt(strTkr.nextToken());

            if (numberA == 0 && numberB == 0) {
                break;

            }
            stringBuilder.append((numberA + numberB)).append('\n');
        }
        System.out.println(stringBuilder);
    }
}
~~~
* 이게 정말로 맞는 풀이이다.
    * 원래 println의 위치는 잘못되었다. 입력받을 때마다 출력이 생긴다.
    * stringbuilder에 append를 모두 다 완료하고 출력한다는 점을 생각하지 못했따.
    * bufferedReader.readLine() 과 한 줄씩 입력받는 것에 대한 잘못된 생각이 있었다. (두번째 항문)
    

#[문제 10951](https://www.acmicpc.net/problem/10951)
## 나의 풀이 1
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        while(true) {
            StringTokenizer strTkr = new StringTokenizer(bufferedReader.readLine());

            if (!strTkr.hasMoreTokens()) {
                break;
            }
            else {
                int numberA = Integer.parseInt(strTkr.nextToken());
                int numberB = Integer.parseInt(strTkr.nextToken());
                stringBuilder.append((numberA + numberB)).append('\n');
            }
        }
        System.out.println(stringBuilder);
    }
}
~~~
* 뭔가 이것 이외에 더 좋은 풀이가 있을 것 같다
* 지금 생각나는 것
  * stringTokenizer는 항상 와일문 안에서 생성되는가? 선어만 먼저하고 while문 조건 안으로 들어갈 수는 없을까?
  * 선언만 먼저하는 게 아니라 인스턴스를 밖에서 만들어버리면, 한줄만 입력받고 끝나나? 한줄단위로 받는건가?
  * 내가 뭔가 이해가 부족하다라는 걸 느낀다 어려운 부분은 아닌 것 같으면서도.
  
## 나의 풀이 2
~~~java
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        String str = " ";
        // buffer는 계속 살아있고, 입력을 받기 위해 열려있다.
        // 다만 그것에 대해선 readLine이 실행될 때마다 읽어가는 것일 뿐이다.
      
        while( (str = bufferedReader.readLine()) != null){
            stringTokenizer = new StringTokenizer(str);

            int numberA = Integer.parseInt(stringTokenizer.nextToken());
            int numberB = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(numberA + numberB).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
~~~
* 이 문제는 정말 많은 걸 알려주는 문제다.
* EOF를 받는 것과 엔터를 받는 것이 지대한 차이가 있음을 깨달았다
* str = bufferedReader.readline() 하는 의미를 처음에는 알지 못했다
  * 일단 bufferedReader.readline()을 만약 한 번 뒤에서 더 하게 된다면 그것은 null을 읽기 때문에 다음 while 조건에서 끝나야 하는 것을 먼저 발견해서 NPE를 유발한다.
  * 또한 while 조건문 내에서 str = bufferdReader.readLine()을 수행하면서 그것이 null인지 아닌지를 검사할 수 있게 된다.
  * 그리고 거기서 str이라는 것을 할당해 주었기 때문에, 뒤에서 str을 계속해서 새로 bufferedLine을 하지 않고 이용할 수 있게 된다는 점이 있다.
  
* EOF 를 처리하는 문제가 나온다면 이 문제는 나를 살린 셈이다.. 이걸 이제 알았다는 게 충격적이다.
* ctrl+D가 EOF임을 잊지 말자.
* 그리고 한 번에 모아서 보여주는 것이 문제가 원하는 것이므로, 매번 system.out.println을 할 필요가 없고
* stringBuilder에 계속 append로 더해주다가 마지막에만 보여주면 되는 것
