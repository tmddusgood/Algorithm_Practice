package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2438 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int total = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < total; i++){
            System.out.println(stringBuilder.append("*"));
        }
    }
}