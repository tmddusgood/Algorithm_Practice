package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기0104 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());


        for (int i = 0; i < N; i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bufferedReader.readLine()).reverse();
            System.out.println(stringBuilder);
        }
    }
}
