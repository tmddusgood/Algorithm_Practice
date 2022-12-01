package acmicpc.book.complete.silver;

import java.util.Scanner;

public class bj11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataNumber = scanner.nextInt();
        int questionNumber = scanner.nextInt();
        int[] numbers = new int[dataNumber];
        int[] partSum = new int[dataNumber];

        int sum = 0;
        for (int i = 0; i < dataNumber; i++) {
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
            partSum[i] = sum;
        }

        for (int i = 0; i < questionNumber; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start == end) System.out.println(numbers[start - 1]);
            else System.out.println(partSum[end - 1] - partSum[start - 1] + numbers[start - 1]);
        }
    }
}