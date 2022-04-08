package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class bj12891_2 {
    static char[] chars;
    static int size;
    static int N;
    static int[] counts = new int[4];
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());
        chars = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) counts[i] = Integer.parseInt(st.nextToken());

        HashMap<Character, Integer> wMap = new HashMap<>();
        for (int i = 0; i < size; i++) wMap.put(chars[i], wMap.getOrDefault(chars[i], 0) + 1);
        verify(wMap);

        for (int i = 1; i < N - size + 1; i++){
                wMap.put(chars[i-1], wMap.get(chars[i-1]) - 1);
                wMap.put(chars[i + size - 1], wMap.getOrDefault(chars[i + size - 1], 0) + 1);
                verify(wMap);
        }
        System.out.println(answer);
    }

    static void verify(HashMap<Character, Integer> windowMap){
        boolean flag = true;
        if (windowMap.getOrDefault('A', 0) < counts[0]) flag = false;
        else if (windowMap.getOrDefault('C', 0) < counts[1]) flag = false;
        else if (windowMap.getOrDefault('G', 0) < counts[2]) flag = false;
        else if (windowMap.getOrDefault('T', 0) < counts[3]) flag = false;
        if(flag) answer++;
    }
}
