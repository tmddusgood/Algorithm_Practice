package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int loopTotal = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < loopTotal; i++){
            String[] numbers = bufferedReader.readLine().split(" ");
            System.out.println(Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]));
        }
    }
}
