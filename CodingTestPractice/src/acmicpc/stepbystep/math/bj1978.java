package acmicpc.stepbystep.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1978 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] targets = bufferedReader.readLine().split(" ");
        int answer = 0;

        for (String target : targets) if (verify(Integer.parseInt(target))) answer ++;
        System.out.println(answer);
    }

    static boolean verify(int target){
        int pointer = 0;
        for (int i = 1; i <= target; i ++) if (target % i == 0) pointer++;
        return (pointer == 2) ? true : false;
    }
}
