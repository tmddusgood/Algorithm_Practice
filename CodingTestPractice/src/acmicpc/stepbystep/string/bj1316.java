package acmicpc.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        boolean[] alphabets = new boolean[26];
        int answer = N;

        for (int i = 0; i < N; i++){
            Arrays.fill(alphabets, false);
            char previous = '#';

            String line = bufferedReader.readLine();
            for (char character : line.toCharArray()){
                if(alphabets[(character - 97)] && character != previous){
                    answer--;
                    break;
                }
                else{
                    alphabets[character - 97] = true;
                    previous = character;
                }
            }
        }
        System.out.println(answer);
    }
}
