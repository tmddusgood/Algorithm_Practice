package acmicpc.book.complete.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11724_2 {
    static ArrayList<Integer>[] ADJANCY;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeN = Integer.parseInt(st.nextToken());
        int edgeN = Integer.parseInt(st.nextToken());

        ADJANCY = new ArrayList[nodeN + 1];
        VISITED = new boolean[nodeN + 1];

        for (int i = 0; i < nodeN + 1; i++){
            ADJANCY[i] = new ArrayList<Integer>();
            VISITED[i] = false;
        }

        for (int i = 0; i < edgeN; i++){
            st = new StringTokenizer(br.readLine());
            int nodeOne = Integer.parseInt(st.nextToken());
            int nodeTwo = Integer.parseInt(st.nextToken());
            ADJANCY[nodeOne].add(nodeTwo);
            ADJANCY[nodeTwo].add(nodeOne);
        }

        int count = 0;
        for (int i = 1; i < nodeN + 1; i++){
            if (!VISITED[i]){
                DFS(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void DFS(int node){
        if(VISITED[node]) return;
        VISITED[node] = true;
        for(int candidate: ADJANCY[node]) if(!VISITED[candidate]) DFS(candidate);
    }
}
