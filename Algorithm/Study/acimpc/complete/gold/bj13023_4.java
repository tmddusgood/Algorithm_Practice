package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13023_4 {
    static int NODES;
    static int EDGES;
    static ArrayList<Integer>[] ADJANCY;
    static boolean VISITED[];
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NODES = stringToInt(st.nextToken());
        EDGES = stringToInt(st.nextToken());
        ADJANCY = new ArrayList[NODES];
        VISITED = new boolean[NODES];

        for(int i = 0; i < NODES; i++) ADJANCY[i] = new ArrayList<>();

        for (int i = 0; i < EDGES; i++){
            st = new StringTokenizer(br.readLine());
            int firstInput = stringToInt(st.nextToken());
            int secondInput = stringToInt(st.nextToken());

            ADJANCY[firstInput].add(secondInput);
            ADJANCY[secondInput].add(firstInput);
        }

        for (int i = 0; i < NODES; i++){
            Arrays.fill(VISITED, false);
            DFS(0, i);
            if(answer == 1) break;
        }

        System.out.println(answer);
    }

    static void DFS(int depth, int target){
        if(depth == 4) {
            answer = 1;
            return;
        }
        VISITED[target] = true;
        for (int each : ADJANCY[target]) if(!VISITED[each]) DFS(depth + 1, each);
        VISITED[target] = false;
    }
    static int stringToInt(String target){
        return Integer.parseInt(target);
    }
}
