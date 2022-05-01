package acmicpc.book.complete.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String input = bufferedReader.readLine();
        int sum = 0;

        for (int i=0; i < N; i++) sum += input.charAt(i) - '0';

        System.out.println(sum);
    }
}
