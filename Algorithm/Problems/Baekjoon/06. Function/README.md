#[문제1065](https://acmicpc.net/problem/1065)
## 첫번째 풀이
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static int countNumber(int number){
        int count = 0;

        if (number < 100){
            count += number;
        }
        else{
            count += 99;
            for (int i = 100; i <= number; i++){
                String strNumber = String.valueOf(i);
                int numA = strNumber.charAt(0) - '0';
                int numB = strNumber.charAt(1) - '0';
                int numC = strNumber.charAt(2) - '0';

                if ((numA - numB) == (numB - numC)){
                    count += 1;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(countNumber(Integer.parseInt(bufferedReader.readLine())));
    }
}
~~~
* 다 좋은데 다른 사람들 풀이를 보니.. 내가 각 자릿수별 숫자를 아주 바보같이 가져왔다. int 일 때 그냥 %10, %100 해서 가져오면 되는데 함수 호출을 하니 시간이 길어진다.