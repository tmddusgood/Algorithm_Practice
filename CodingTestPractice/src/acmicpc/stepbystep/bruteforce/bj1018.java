package acmicpc.stepbystep.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1018 {
    static char[][] original;
    static int height, width;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = bufferedReader.readLine().split(" ");

        height = Integer.parseInt(sizes[0]);
        width = Integer.parseInt(sizes[1]);
        original = new char[height][width];

        for (int i = 0; i < height; i ++) {
            original[i] = bufferedReader.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height - 7; i++){
            for (int j = 0; j < width - 7; j++){
                min = Math.min(min, count(i, j));
            }
        }

        System.out.println(min);
    }


    static int count(int start, int end){
        int count = 0;
        int correctCount = 0;

        for (int posX = start; posX < start + 8; posX++ ){
            for (int posY = end; posY < end + 8; posY++ ){
                if ((count / 8) % 2 == 1  && count % 2 == 0){
                    if(original[posX][posY] == 'W') correctCount++;
                }
                else if ((count / 8) % 2 == 1  && count % 2 == 1){
                    if (original[posX][posY] == 'B') correctCount++;
                }
                else if(((count / 8) % 2) == 0 && count % 2 == 0){
                    if (original[posX][posY] == 'B') correctCount++;
                }
                else if(((count / 8) % 2) == 0 && count % 2 == 1){
                    if (original[posX][posY] == 'W') correctCount++;
                }
                count++;
            }
        }

        return Math.min(correctCount, 64 - correctCount);
    }
}