package acmicpc.stepbystep.twodarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];

        int max = Integer.MIN_VALUE;
        int maxLocationHeight = 99;
        int maxLocationWidth = 99;

        for (int i = 0; i < 9; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (map[i][j] >= max){
                    max = map[i][j];
                    maxLocationHeight = i + 1;
                    maxLocationWidth = j + 1;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(max).append("\n").append(maxLocationHeight).append(" ").append(maxLocationWidth);
        System.out.println(stringBuilder);
    }
}
