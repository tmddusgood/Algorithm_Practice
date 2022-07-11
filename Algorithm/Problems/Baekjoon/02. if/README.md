# 문제 1
> ###문제
> 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
>###입력
>첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
>###출력
>첫째 줄에 다음 세 가지 중 하나를 출력한다. <br>
> * A가 B보다 큰 경우에는 '>'를 출력한다. <br>
> * A가 B보다 작은 경우에는 '<'를 출력한다. <br>
> * A와 B가 같은 경우에는 '=='를 출력한다. <br>

## 풀이
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strTkr = new StringTokenizer(bufferedReader.readLine());

        int numA = Integer.parseInt(strTkr.nextToken());
        int numB = Integer.parseInt(strTkr.nextToken());

        if (numA > numB){
            System.out.println(">");
        }
        else if(numA == numB){
            System.out.println("==");
        }
        else{
            System.out.println("<");
        }
    }
}
~~~