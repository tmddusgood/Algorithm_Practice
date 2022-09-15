package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj2023 {
    static int N;
    static ArrayList<Integer> RESULTS;
    static int[] PRIMES = {2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        RESULTS = new ArrayList<>();

        for (int prime : PRIMES) DFS(0, prime);
        for (int result : RESULTS) System.out.println(result);
    }
    static void DFS(int depth, int number) {
        if (depth == N - 1 && verifyPrime(number)) RESULTS.add(number);
        else if (verifyPrime(number)) for (int i = 0; i < 10; i++) DFS(depth + 1, 10 * number + i);
    }
    static boolean verifyPrime(int number) {
        for (int i = 2; i < number; i++) if (number % i == 0) return false;
        return true;
    }
}
