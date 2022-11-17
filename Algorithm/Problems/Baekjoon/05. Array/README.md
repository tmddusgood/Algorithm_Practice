[문제 2577](https://acmicpc.net/problem/2577)
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

#[문제4344](https://www.acmicpc.net/problem/4344)
## 첫번째 풀이
~~~java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        int caseNum = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<caseNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int studentNum = Integer.parseInt(stringTokenizer.nextToken());
            int[] scoreArray = new int[studentNum];

            int total = 0;
            for (int j=0; j<studentNum; j++) {
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                total += temp;
                scoreArray[j] = temp;
            }

            double average = (double)total / studentNum;

            int higherAverageCount = 0;

            for (int temp : scoreArray){
                if ((double)temp > average){
                    higherAverageCount += 1;
                }
            }

            double resultPortion = (double) higherAverageCount / studentNum * 100;

            stringBuilder.append(String.format("%.3f", resultPortion)).append("%").append('\n');
        }
        System.out.println(stringBuilder);
    }
}
~~~
* 드디어 내가 지금까지 배운 것을 한 번에 잘 녹여서 풀이했다는 생각이 든다.
    * BufferedReader 의 작동 원리를 이해하고 한 번에 바로 이를 활용할 수 있었다.
    * 배열 자료형을 잘 선언했고
    * 불필요한 배열 선언이 있는지 아닌지 고민했고 (배열에 저장할 필요가 애초에 없는 경우도 있음)
    * StringBuilder를 쓰지 않다가 나중에 한 번에 돌려줘야 하는 부분이 있는 것을 알고 잘 활용했다.
      * 이 때 끝에 '/n'을 잘 붙여서 출력형식에 맞춘 것도 좋았다.
    * import 부분에서의 4개를 잘 기억해내서 자동 추가가 아니라 직접 썼고
    * throws IOExeption도 경고가 뜨기 전에 내가 먼저 썼으며
    * (double) 자료형이 하나 붙어야 int 끼리의 계산에서 double 자료형을 받을 수 있다는 점도 파악하고 바로 그렇게 했다.
* 다만 내가 소수점 몇 째 자리에서 반올림하는 것을 몰랐다는 것은 충격이다. 반드시 기억하자. 이것도 검색을 해보니 다음의 형식이 좋아보인다.
* Math.round() 가 있는데 이건 내가 자릿수를 설정하지 못한다는 점에서 별로였고
    * String.format("%f", 변수) 가 가장 적합하다고 판단했다.
* 다른 사람들의 풀이를 보니, 나의 풀이와 유사하고, 심지어는 내가 성능적으로도 괜찮아보인다. 뿌듯하다.