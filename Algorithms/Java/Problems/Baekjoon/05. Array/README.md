#[문제 2577](https://acmicpc.net/problem/2577)
##첫번째 풀이
~~~java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numArray= new String[3];

        for (int i = 0; i < 3; i ++){
            String tempNum = bufferedReader.readLine();
            numArray[i] = tempNum;
        }

        int resultNum = Integer.parseInt(numArray[0]) * Integer.parseInt(numArray[1]) * Integer.parseInt(numArray[2]);

        String resultNumStr = String.valueOf(resultNum);
        int[] countArray = new int[10];

        for (int i=0; i < resultNumStr.length(); i ++){
            countArray[resultNumStr.charAt(i) - '0']++;
        }

        for (int v : countArray){
            System.out.println(v);
        }

    }
}
~~~
* 배열 선언 방법에 다양한 방법이 있다. 나는 자료형[] 이름 = new 자료형[크기]; 이걸로 하려고 한다.
* 문제를 풀 수 있는 여러가지 방법이 보였는데, 스플릿을 쓰거나 replace를 써도 풀이는 됐을 것 같다. 그런데 이게 가장 포괄적으로 쓸 수 있는 방식의 풀이라고 생각했다.
* 내가 배열을 사용하는 법에 대해서 잘 모르는 것 같다. 생각해보면 이미 보이기로, 굳이 readline을 할 것을 배열에 저장할 필요는 없어 보인다. 바로 readline을 한 번 씩 해도 되겠다.
* primitive 타입을 사용하니 wrapper class를 썼을 때보다 속도가 더 잘 나오는 것이 보이니 신기하다.
* countArray에 값을 넣는 부분에서, 내가 10개를 순서에 맞게 선언한 것을 이용해서 if문을 쓰지 않아도 되는데 이걸 if문으로 보려했다는 점이 조금 부끄럽다.
##두번째 풀이
~~~java
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int resultNum = Integer.parseInt(bufferedReader.readLine()) 
                * Integer.parseInt(bufferedReader.readLine()) 
                * Integer.parseInt(bufferedReader.readLine());

        String resultNumStr = String.valueOf(resultNum);
        int[] countArray = new int[10];

        for (int i=0; i < resultNumStr.length(); i ++){
            countArray[resultNumStr.charAt(i) - '0']++;
        }

        for (int v : countArray){
            System.out.println(v);
        }

    }
}
~~~
* 불필요한 배열 선언과 사용 부분을 없앴다.
* 마찬가지로, 이는 데이터의 크기가 커졌을 때 영향을 끼칠 수 있고, 지금의 경우에는 큰 차이를 보이지는 않는다.