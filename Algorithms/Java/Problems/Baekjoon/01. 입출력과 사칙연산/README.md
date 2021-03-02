#문제 1
> Hello World!를 출력하시오.

#풀이
~~~java
public class Main {
	public static void main(String[] args) {
        System.out.println("Hello World!");
	}
}
~~~

#문제 2
> 강한친구 대한육군 을 한 줄에 한 번씩 출력..한다?

#풀이
~~~java
public class Main {
	public static void main(String[] args) {
        System.out.println("강한친구 대한육군");
        System.out.println("강한친구 대한육군");
	}
}
~~~

#문제 3
~~~
/*
> \    /\
)  ( ')
(  /  )
\(__)| 
를 출력한다
*/
~~~

~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
}
~~~
* "\\" 를 쓰고 싶다면 백슬래시를 2번 쳐야 한다.
* []를 붙이면 문자 그대로 인식하는 경우가 있따
* 다른 특수 문자의 경우 \\를 붙이거나 하는 식으로 해결한다.
* 특수 문자를 입력하는 방식을 알게 되는 문제


# 문제 4
# 풀이
~~~java
public class Main {
    public static void main(String[] args) {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }
}
~~~
* " 를 출력하고 싶으면 \\" 를 써야한다!

# 문제 5
> 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
> 첫째 줄에 A+B를 출력한다.

~~~java
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] strArray = bufferedReader.readLine().split(" ");
        System.out.println(Integer.valueOf(strArray[0]) + Integer.valueOf(strArray[1]));

    }
}
~~~
* split() 대신에 String Tokenizer를 쓰는 것이 성능에 더 유리하다
* 람다를 써보고 싶다 여기서!
* 지금은 그냥 프린트문에 위에서 선언할 애들을 때려박았다.
* 뭔가 클린한 코드를 만들어보고 싶다 괜히 여기서
* BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 은 버릇처럼 외워야 한다.
* br.readline().split() 그리고 Integer.valueOf()도 마찬가지이다

## 람다식을 괜히 한 번 써보았다
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public interface StringConcat {
        void returnResult(String s1, String s2);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        StringConcat concat1 = (s, v) -> System.out.println(Integer.valueOf(s) + Integer.valueOf(v));
        concat1.returnResult(stringTokenizer.nextToken(), stringTokenizer.nextToken());
    }
}
~~~
* 람다식을 썼을 때의 장점보다는 단점이 부각되는 코드인 것 같다.
* 가독성이 좋아보이는 것도 아니고, 이런 단순한 함수에 굳이 람다식을 쓸 필요는 없다고 생각한다.
* 클린코드의 관점에서 람다식을 무조건 긍정적으로 볼 필요는 없을 것 같다
* 물론 이 경우 알고리즘에서 클린코드의 관점으로 접근할 필요는 없는 것 같다.

# 문제 6
> 첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)
> 첫째 줄에 A-B를 출력한다.
~~~java
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int numA = Integer.parseInt(stringTokenizer.nextToken());
        int numB = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(numA - numB);
    }
}
~~~