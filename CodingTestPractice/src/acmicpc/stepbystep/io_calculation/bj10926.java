package acmicpc.stepbystep.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(inputString);
        stringBuilder.append("??!");

        System.out.println(stringBuilder.toString());
    }
}
