package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2018{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(bufferedReader.readLine());

        int startPos = 1;
        int endPos = 1;
        int sum = 1;
        int answer = 1;

        while (endPos != target) {
            if (sum == target) {
                answer++;
                endPos++;
                sum += endPos;
            } else if (sum > target) {
                sum = sum - startPos;
                startPos++;
            } else {
                endPos++;
                sum += endPos;
            }
        }

        System.out.println(answer);
    }
}
