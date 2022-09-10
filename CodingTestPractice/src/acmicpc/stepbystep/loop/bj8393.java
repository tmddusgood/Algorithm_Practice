package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bj8393 {

    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int totalNumber = Integer.parseInt(bufferedReader.readLine());
        int sum = 0;

        for (int i = 1; i < totalNumber + 1; i++){
            sum += i;
        }

        System.out.println(sum);
    }
}
