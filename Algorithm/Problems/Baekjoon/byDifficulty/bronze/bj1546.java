package acmicpc.book.complete.bronze;

import java.util.Scanner;
public class bj1546 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        String nothing = scanner.nextLine();
        String rawInput = scanner.nextLine();

        String[] arrayNumber = rawInput.split(" ");
        int[] arrayScore = new int[number];

        for (int i = 0; i < number; i++){
            int tempScore = Integer.parseInt(arrayNumber[i]);
            arrayScore[i] = tempScore;
        }

        long maxScore = 0;
        long totalScore = 0;

        for (int i = 0; i < number; i++){
            if(arrayScore[i] > maxScore){
                maxScore = arrayScore[i];
            }
            totalScore += arrayScore[i];
        }

        System.out.println((double)totalScore / maxScore / number * 100);
    }
}
