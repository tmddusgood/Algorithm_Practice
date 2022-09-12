package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class bj11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer[]> mydeque = new ArrayDeque<>();
        mydeque.add(new Integer[]{Integer.parseInt(st.nextToken()), 0});
        sb.append(mydeque.peekFirst()[0]).append(" ");

        for (int i = 1; i < N; i++) {
            Integer[] currentPair = new Integer[]{Integer.parseInt(st.nextToken()), i};
            while(!mydeque.isEmpty() && mydeque.peekLast()[0] > currentPair[0]) mydeque.pollLast();
            mydeque.add(currentPair);
            while(!mydeque.isEmpty() && mydeque.peekFirst()[1] < i - L + 1) mydeque.pollFirst();
            sb.append(mydeque.peekFirst()[0]).append(" ");
        }

        System.out.println(sb);
    }
}
