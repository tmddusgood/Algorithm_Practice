package acmicpc.stepbystep.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int score = Integer.parseInt(input);
        String grade = score >= 90 && score <= 100 ? "A" : score >= 80 && score < 90 ? "B"
                : score >= 70 && score < 80 ? "C" : score >= 60 && score < 70 ? "D" : "F";

        System.out.println(grade);
    }
}
