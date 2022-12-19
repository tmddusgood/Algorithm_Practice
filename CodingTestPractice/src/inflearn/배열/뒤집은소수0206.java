package inflearn.배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 뒤집은소수0206 {
    public boolean verifyPrime(int target){
        boolean[] noPrime = new boolean[target + 1];
        noPrime[0] = true;
        noPrime[1] = true;

        for (int i = 2; i <= target; i++){
            int temp = 2;
            while(temp * i <= target){
                noPrime[temp * i] = true;
                temp++;
            }
        }
        return !noPrime[target];
    }
    public int toInt(String target){
        StringBuilder sb = new StringBuilder();
        for (int i = target.length() - 1; i >= 0; i--){
            sb.append(target.toCharArray()[i]);
        }
        return Integer.parseInt(sb.toString());
    }
    public String solution(int N, StringTokenizer st){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int target = toInt(st.nextToken());
            if(verifyPrime(target)) sb.append(target).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        뒤집은소수0206 T = new 뒤집은소수0206();
        System.out.println(T.solution(N, st));
    }
}
