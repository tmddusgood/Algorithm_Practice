package acmicpc.stepbystep.twodarray;

import java.util.Scanner;

public class bj2738_2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();

        int[][] map = new int[height][width];

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                stringBuilder.append(map[i][j] + scanner.nextInt()).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
