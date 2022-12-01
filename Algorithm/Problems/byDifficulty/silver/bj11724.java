package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11724 {
    static ArrayList<Integer>[] ADJANCY;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        // static 자료구조 초기화
        ADJANCY = new ArrayList[nodeCount + 1];
        VISITED = new boolean[nodeCount + 1];
        for (int i = 1; i < nodeCount + 1; i++) {
            ADJANCY[i] = new ArrayList<>();
            VISITED[i] = false;
        }

        // 인접행렬 채우기
        for (int i = 0; i < edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ADJANCY[start].add(end);
            ADJANCY[end].add(start);
        }

        int count = 0;
        for (int i = 1; i < nodeCount + 1; i++){
            if(!VISITED[i]){
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }
    static void DFS(int node){
        if(VISITED[node]) return;
        VISITED[node] = true;
        for (int each : ADJANCY[node]) if (!VISITED[each]) DFS(each);
    }
}
