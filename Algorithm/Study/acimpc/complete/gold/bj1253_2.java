package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1253_2 {
    static HashMap<Integer, Integer> answerIndex = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
//        int[] numbers = new int[N];
        ArrayList<Integer> numberList = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

//        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) numberList.add(Integer.parseInt(stringTokenizer.nextToken()));
        Collections.sort(numberList);

        for (int target = 0; target < N; target++) {
            int start = 0, end = N - 1;

            while (start < end) {
                if (numberList.get(start) + numberList.get(end) > numberList.get(target)) end--;
                else if (numberList.get(start) + numberList.get(end) < numberList.get(target)) start++;
                else {
                    if (start == target) start++;
                    else if (end == target) end--;
                    else {
                        answerIndex.putIfAbsent(target, 1);
                        break;
                    }
                }
            }
        }
        System.out.println(answerIndex.keySet().size());
    }
}

