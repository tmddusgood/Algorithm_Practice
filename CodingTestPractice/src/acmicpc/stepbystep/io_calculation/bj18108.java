package acmicpc.stepbystep.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj18108 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int before = Integer.parseInt(input);
        int difference = 2541 - 1998;

        System.out.println(before - difference);
    }
}
