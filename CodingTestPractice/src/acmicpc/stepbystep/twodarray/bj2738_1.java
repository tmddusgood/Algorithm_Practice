package acmicpc.stepbystep.twodarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2738_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int height = Integer.parseInt(stringTokenizer.nextToken()), width = Integer.parseInt(stringTokenizer.nextToken());
        int[][] mapOne = new int[height][width];
        int[][] mapTwo = new int[height][width];

        mapOne = buildMap(mapOne, bufferedReader, width);
        mapTwo = buildMap(mapTwo, bufferedReader, width);

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                mapOne[i][j] += mapTwo[i][j];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                stringBuilder.append(mapOne[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

    public static int[][] buildMap(int[][] map, BufferedReader bufferedReader, int width) throws IOException{
        for (int[] mapLine : map){
            String[] temp = bufferedReader.readLine().split(" ");
            for (int i = 0; i < width; i++){
                mapLine[i] = Integer.parseInt(temp[i]);
            }
        }

        return map;
    }


}
