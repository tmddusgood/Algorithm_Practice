import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        if (number < 100) {
            System.out.println(number);
        } else {
            System.out.println(countNumber(number));
        }
    }

    public static int countNumber(int number) {
        int count = 99;

        if(number == 1000){
            number = 999;
        }

        for (int i = 100; i <= number; i++) {
            int numA = i / 100;
            int numB = (i % 100) / 10;
            int numC = (i % 10);

            if ((numA - numB) == (numB - numC)) {
                count++;
            }
        }
        return count;
    }
}