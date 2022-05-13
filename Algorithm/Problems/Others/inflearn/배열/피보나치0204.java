package inflearn.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치0204 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int first = 1;
        int second = 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first).append(" ").append(second).append(" ");

        for (int i = 3; i <= N; i++){
            int third = first + second;
            stringBuilder.append(third).append(" ");
            first = second;
            second = third;
        }

        System.out.println(stringBuilder);
    }
}
