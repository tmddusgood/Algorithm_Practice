package acmicpc.stepbystep.onedmarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int caseTotal = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < caseTotal; i++) {
            String[] readLineArray = bufferedReader.readLine().split(" ");

            int sum = 0;
            int count = 0;

            for (int j = 0; j < readLineArray.length - 1; j++) sum += Integer.parseInt(readLineArray[j + 1]);
            for (int j = 0; j < readLineArray.length - 1; j++) if (Integer.parseInt(readLineArray[j + 1]) > (sum / (readLineArray.length - 1))) count++;
            double beforeResult = 100 * (double) count / (double) (readLineArray.length - 1);

            System.out.println((String.format("%.3f", beforeResult)) + "%");
        }
    }
}
