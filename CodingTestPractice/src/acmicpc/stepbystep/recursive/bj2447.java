package acmicpc.stepbystep.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2447 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 3; i++){
//            for (int j = 0; j < 3; j++){
//                if (i != 1 || j != 1) sb.append(buildString(N/3));
//                else sb.append(" ");
//            }
//        }
        System.out.println(buildString(N));
    }

    static String buildString(int N){
        StringBuilder sb = new StringBuilder();
        if (N == 3){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (i != 1 || j != 1) sb.append("*");
                    else sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
        else {
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (i != 1 || j != 1) sb.append(buildString(N/3));
                    else sb.append(" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
