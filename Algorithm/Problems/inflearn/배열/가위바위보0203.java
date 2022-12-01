package inflearn.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 가위바위보0203 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String[][] results = {{"1", "2", "3", "1", "2", "3", "1", "2", "3"}
                , {"1", "1", "1", "2", "2", "2", "3", "3", "3"}, {"D", "A", "B", "B", "D", "A", "A", "B", "D"}};

        String[] chooseA = bufferedReader.readLine().split(" ");
        String[] chooseB = bufferedReader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 9; j++) {
                if (results[0][j].equals(chooseA[i]) && results[1][j].equals(chooseB[i]))
                    System.out.println(results[2][j]);
            }
        }
    }
}
