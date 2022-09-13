package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11021 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < total; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            System.out.println("Case #" + (i + 1) + ": " + ((Integer.parseInt(stringTokenizer.nextToken())) + (Integer.parseInt(stringTokenizer.nextToken()))));
        }
    }
}
