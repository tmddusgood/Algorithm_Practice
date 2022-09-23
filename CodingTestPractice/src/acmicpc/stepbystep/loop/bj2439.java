package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2439 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int total = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i < total + 1; i++){
            char[] temp = new char[total - i];
            Arrays.fill(temp, " ".toCharArray()[0]);
            String blank = new String(temp);
            System.out.println(blank + stringBuilder.append("*"));
        }
    }
}
