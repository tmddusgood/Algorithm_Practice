package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] numbers = new int[N];
        int[] sum = new int[N];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int tempSum = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            tempSum += numbers[i];
            sum[i] = tempSum;
        }

        // sum을 만들고 다시 그걸 순회하는 방법이 시간 초과가 발생할 확률이 높다.
        // 그것조차도 순회를 하지 않고 바로 구할 수 있어야 하는데
        // 이 문제의 경우에는 수학적으로 접근하는 것이 답이었다.
        // 그렇게 어려운 수학적 개념도 아님..
        int answer = 0;
        for (int i = 0; i < N; i++){
            for (int j = i; j < N; j++){
                if ((sum[j] - sum[i] + numbers[i]) % M == 0) answer ++;
            }
        }

        System.out.println(answer);
    }
}
