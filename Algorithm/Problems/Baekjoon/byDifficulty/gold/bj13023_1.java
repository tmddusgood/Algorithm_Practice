package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13023_1 {
    static ArrayList<Integer>[] MAP;
    static int EDGES;
    static int NODES;
    static boolean ANSWER = false;
    static boolean VISITED[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NODES = Integer.parseInt(st.nextToken());
        EDGES = Integer.parseInt(st.nextToken());

        // 첫 필터링
        if (EDGES < 4 || NODES < 5) System.out.println(0);
        else{
            // 필요 배열 초기화하고
            MAP = new ArrayList[NODES];
            VISITED = new boolean[NODES];


            for (int i = 0; i < NODES; i++){
                MAP[i] = new ArrayList<>();
            }

            for (int i = 0; i < NODES; i++){
                st = new StringTokenizer(br.readLine());
                int friendA = Integer.parseInt(st.nextToken());
                int friendB = Integer.parseInt(st.nextToken());
                MAP[friendA].add(friendB);
                MAP[friendB].add(friendA);
            }

            // 시작점 정하기
            for (int i = 0; i < NODES; i++){
                Arrays.fill(VISITED, false);
                DFS(0, i);
                if (ANSWER) break;
            }
        }

        System.out.println(ANSWER);
    }

    public static void DFS(int depth, int currentAt){
        if(depth == 4) {
            ANSWER = true;
            return;
        }

        VISITED[currentAt] = true;

        for (int each : MAP[currentAt]){
            if(depth != 4){
                if(!VISITED[each]) DFS(depth + 1, each);
            }
        }
    }
}
