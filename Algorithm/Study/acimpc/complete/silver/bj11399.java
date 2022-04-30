package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] minutes = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) minutes[i] = Integer.parseInt(stringTokenizer.nextToken());

        Arrays.sort(minutes);

        int sum = 0;
        for(int each : minutes){
            sum += each * N;
            N--;
        }

        System.out.println(sum);
    }
}
