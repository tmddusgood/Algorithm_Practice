package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 중복문자제거0106 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = bufferedReader.readLine().toCharArray();
        String answer = "";

        for (char each : inputs){
            String converted = String.valueOf(each);
            if (!answer.contains(String.valueOf(each))) answer = answer.concat(converted);
        }

        System.out.println(answer);
    }
}
