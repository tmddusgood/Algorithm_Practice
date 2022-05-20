package inflearn.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 보이는학생0202 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] inputs = bufferedReader.readLine().split(" ");

        int previous = 0;
        int sum = 0;
        for (String each : inputs){
            int eachInt = Integer.parseInt(each);
            if (eachInt > previous){
                sum++;
                previous = eachInt;
            }
        }

        System.out.println(sum);
    }
}
