package acmicpc.stepbystep.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj14681 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int posX = Integer.parseInt(bufferedReader.readLine());
        int posY = Integer.parseInt(bufferedReader.readLine());

        if (posX > 0){
            if (posY > 0) System.out.println(1);
            if (posY < 0) System.out.println(4);
        }
        if (posX < 0){
            if (posY > 0) System.out.println(2);
            if (posY < 0) System.out.println(3);
        }
    }
}
