package acmicpc.stepbystep.twodarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2563 {
    static int TOTAL_HEIGHT = 100;
    static int TOTAL_WIDTH = 100;

    public static void main(String[] args) throws IOException {
        boolean[][] map = new boolean[TOTAL_HEIGHT][TOTAL_WIDTH];
        for (boolean[] array : map) Arrays.fill(array, false);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(bufferedReader.readLine());

        for ( int i = 0; i < N; i++ ){
            String[] temp = bufferedReader.readLine().split(" ");
            int tempHeight = stoi(temp[0]), tempWidth = stoi(temp[1]);

            for ( int y = tempHeight; y < tempHeight + 10; y++ ){
                for ( int x = tempWidth; x < tempWidth + 10; x++){
                    map[y][x] = true;
                }
            }
        }

        System.out.println(count(map));
    }

    static int stoi(String input) {
        return Integer.parseInt(input);
    }

    static int count(boolean[][] map){
        int count = 0;
        for ( int y = 0; y < TOTAL_HEIGHT; y++ ){
            for ( int x = 0; x < TOTAL_WIDTH; x++) if(map[y][x]) count++;

        }
        return count;
    }
}
