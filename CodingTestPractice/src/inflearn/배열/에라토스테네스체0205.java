package inflearn.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 에라토스테네스체0205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] noPrime = new boolean[N + 1];
        noPrime[0] = true;
        noPrime[1] = true;

        for (int i = 2; i <= N; i++){
            int temp = 2;
            while(temp * i <= N){
                noPrime[temp * i] = true;
                temp++;
            }
        }

        int answer = 0;
        for (int i = 0; i <= N; i++){
            if(!noPrime[i]) answer++;
        }

        System.out.println(answer);
    }
}
