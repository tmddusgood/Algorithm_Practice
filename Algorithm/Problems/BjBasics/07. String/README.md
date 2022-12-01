#[문제11654](https://acmicpc.net/problem/11654)
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = bufferedReader.readLine();
        System.out.println(inputStr.charAt(0) - 0);
    }
}
~~~
* 아스키 코드를 뽑고 싶으면 char 형태의 코드에서 - 0를 하면 된다.