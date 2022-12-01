package inflearn.문자열;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 암호0112 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[] inputs = br.readLine().toCharArray();

        for (int i = 0; i < N; i++){
            char[] temp = new char[7];
            for (int j = 0; j < 7; j++){
                temp[j] = inputs[i * 7 + j];
            }
            sb.append((char)(toAsciiNumber(temp)));
        }

        System.out.println(sb);
    }

    static int toAsciiNumber(char[] input){
        int[] temp = new int[7];

        for (int i = 0; i < 7; i++){
            if (input[i] == '*') temp[i] = 0;
            else temp[i] = 1;
        }

        int sum = 0;
        for (int i = 0; i < 7; i++){
            sum += Math.pow(2, 6 - i) * temp[i];
        }

        return sum;
    }
}
