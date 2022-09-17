package acmicpc.stepbystep.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj3003 {
    public static void main(String[] args) throws  IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        String[] givens = input.split(" ");
        Integer[] givensToInteger = new Integer[givens.length];
        Integer[] rightSet = {1, 1, 2, 2, 2, 8};

        for (int i=0; i<givens.length; i++) givensToInteger[i] = Integer.parseInt(givens[i]);
        for (int i=0; i<givens.length; i++) givensToInteger[i] = rightSet[i] - givensToInteger[i];

        for(int i = 0; i < givens.length; i++){
            stringBuilder.append(givensToInteger[i]);
            if( i != (givens.length - 1) ) stringBuilder.append(" ");

        }

        System.out.println(stringBuilder.toString());
    }
}
