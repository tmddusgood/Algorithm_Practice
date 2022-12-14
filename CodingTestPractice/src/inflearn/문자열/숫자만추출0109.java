package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출0109 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = bufferedReader.readLine().toCharArray();

        StringBuilder stringBuilder = new StringBuilder();

        for (char each : inputs) {
            if (each >= 48 && each <= 57) stringBuilder.append(each);
        }

        System.out.println(Integer.parseInt(stringBuilder.toString()));
    }
}
