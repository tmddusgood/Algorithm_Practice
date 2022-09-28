package acmicpc.stepbystep.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1065 {
    static int count = 99;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        if( number < 100 ) System.out.println(number);
        else if( number < 1000 ) System.out.println(countNumber(number));
        else System.out.println(countNumber(number - 1));
    }

    public static int countNumber(int number) {
        for (int i = 100; i <= number; i++) {
            int numA = i % 10;
            int numB = i / 10 % 10;
            int numC =  i / 100 % 10;

            if ((short)(numA - numB) == (short)(numB - numC)) count++;
        }
        return count;
    }
}
