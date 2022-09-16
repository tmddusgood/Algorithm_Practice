package acmicpc.stepbystep.loop;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj15552 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < total; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            stringBuilder.append((Integer.parseInt(stringTokenizer.nextToken()) + Integer.parseInt(stringTokenizer.nextToken()))).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
