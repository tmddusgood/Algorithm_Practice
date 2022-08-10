package acmicpc.stepbystep.onedmarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < N; i++){
            int count = 0;
            boolean combo = true;
            char[] charLine = bufferedReader.readLine().toCharArray();

            for (char each : charLine) {
                if (each == 'O'){
                    if(combo) count++;
                    else
                    count++;
                }
                else {
                    combo = false;
                    count = 0;
                }
            }

            System.out.println(count);
        }
    }
}
