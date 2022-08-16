package acmicpc.stepbystep.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int crawlUp = Integer.parseInt(stringTokenizer.nextToken());
        int fall = Integer.parseInt(stringTokenizer.nextToken());
        int height = Integer.parseInt(stringTokenizer.nextToken());

        if (height <= crawlUp) System.out.println(1);
        else {
            double temp = (double)(height - crawlUp) / (crawlUp - fall);
            if ((temp * 10) % 10 != 0) System.out.println((int)temp + 2);
            else System.out.println((int)temp + 1);
        }
    }
}
