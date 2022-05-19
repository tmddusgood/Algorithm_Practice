package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문문자열0107 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bufferedReader.readLine());
        String temp = stringBuilder.reverse().toString().toLowerCase();
        if (temp.equals(stringBuilder.reverse().toString().toLowerCase())) System.out.println("YES");
        else System.out.println("NO");
    }
}
