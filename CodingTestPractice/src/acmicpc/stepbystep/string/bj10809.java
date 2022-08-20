package acmicpc.stepbystep.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10809 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = bufferedReader.readLine().toCharArray();

        Integer[] alphabets = new Integer[26];
        Arrays.fill(alphabets, -1);

        for (int index = 0; index < input.length; index++) {
            if(alphabets[input[index] - 97] == -1){
                alphabets[input[index] - 97] = index;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int each : alphabets) stringBuilder.append(" ").append(each);
        stringBuilder.delete(0, 1);
        System.out.println(stringBuilder);
    }
}
