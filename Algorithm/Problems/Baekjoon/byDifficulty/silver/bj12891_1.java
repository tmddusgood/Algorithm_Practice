package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj12891_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        char[] characters = bufferedReader.readLine().toCharArray();

        int[] counts = new int[4];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            counts[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N - size + 1; i++) {
            boolean flag = true;
            int[] comapares = new int[4];
            for (int j = i; j < (i + size); j++) {
                if (characters[j] == 'A') comapares[0]++;
                else if (characters[j] == 'C') comapares[1]++;
                else if (characters[j] == 'G') comapares[2]++;
                else comapares[3]++;
            }
            for (int k = 0; k < 4; k++) {
                if (comapares[k] < counts[k]) flag = false;
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }
}
