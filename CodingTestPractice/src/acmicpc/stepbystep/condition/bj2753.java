package acmicpc.stepbystep.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int score = Integer.parseInt(input);
        System.out.println((score % 4) == 0  && ((score % 100) != 0 || (score % 400) == 0) ? 1 : 0);
    }
}
