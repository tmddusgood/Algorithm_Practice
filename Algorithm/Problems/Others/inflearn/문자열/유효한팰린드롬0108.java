package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 유효한팰린드롬0108 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine().toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) >= 97 && input.charAt(i) <= 122) stringBuilder.append(input.charAt(i));
        }

        String original = stringBuilder.toString();
        String reversed = stringBuilder.reverse().toString();

        System.out.println(original.equals(reversed) ? "YES" : "NO");
    }
}
