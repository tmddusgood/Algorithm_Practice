package acmicpc.stepbystep.io_calculation;

import java.util.Scanner;

public class bj1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumber = scanner.nextInt();
        int[] inputNumberArray = new int[totalNumber];
        for ( int i = 0; i < totalNumber; i++ ){
            inputNumberArray[i] = scanner.nextInt();
        }
        for(int each: inputNumberArray){
            System.out.println(each);
        }
        System.out.println("Hello world!");
    }
}