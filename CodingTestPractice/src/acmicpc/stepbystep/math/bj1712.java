package acmicpc.stepbystep.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1712 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int fixExp = Integer.parseInt(stringTokenizer.nextToken());
        int variableExp = Integer.parseInt(stringTokenizer.nextToken());
        int price = Integer.parseInt(stringTokenizer.nextToken());

        if (price <= variableExp) System.out.println(-1);
        else System.out.println(fixExp / (price - variableExp) + 1);
    }
}
