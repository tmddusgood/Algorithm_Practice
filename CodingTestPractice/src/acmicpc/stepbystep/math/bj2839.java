package acmicpc.stepbystep.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj2839 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        ArrayList<Integer> answers = new ArrayList<>();

        int bagFiveMax = N / 5;
        int bagThreeMax = N / 3;

        for (int i = 0; i < bagFiveMax + 1; i++){
            for (int j = 0; j < bagThreeMax + 1; j++){
                if (5 * i + 3 * j == N) answers.add(i + j);
            }
        }

        if(answers.isEmpty()) System.out.println(-1);
        else System.out.println(Collections.min(answers));
    }
}
