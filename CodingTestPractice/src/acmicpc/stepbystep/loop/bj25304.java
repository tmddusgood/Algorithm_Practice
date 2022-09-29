package acmicpc.stepbystep.loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj25304 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(bufferedReader.readLine());
        int number = Integer.parseInt(bufferedReader.readLine());
        int tempAmount = 0;

        for (int i = 0; i < number; i++){
            String[] temp = bufferedReader.readLine().split(" ");
            tempAmount += Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]);
        }

        System.out.println((amount == tempAmount) ? "Yes" :"No" );
    }
}
