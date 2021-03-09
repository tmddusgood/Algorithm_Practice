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

## 두번째 풀이
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        if (number < 100) {
            System.out.println(number);
        } else {
            System.out.println(countNumber(number));
        }
    }

    public static int countNumber(int number) {
        int count = 99;

        if(number == 1000){
            number = 999;
        }

        for (int i = 100; i <= number; i++) {
            int numA = i / 100;
            int numB = (i % 100) / 10;
            int numC = (i % 10);

            if ((numA - numB) == (numB - numC)) {
                count++;
            }
        }
        return count;
    }
}
~~~
* 자잘한 변화
    * count += 1 대신에 count ++
    * 자릿수 구하는 것을 string 형변환 거치지 않고 바로 수식 계산으로
    * 만약 숫자가 100보다 작다면 함수 호출을 애초에 하지 않는 것으로
    * 자릿수가 1000이면 애초에 세자리 계산만 할 수 있게끔 (1000은 애초에 카운트가 안 되니까)