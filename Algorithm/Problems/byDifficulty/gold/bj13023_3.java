package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13023_3 {
    static int NODES, EDGES;
    static ArrayList<Integer>[] adjancyList;
    static boolean[] VISITED;
    static boolean ANSWER = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        NODES = stringToInt(st.nextToken());
        EDGES = stringToInt(st.nextToken());
        adjancyList = new ArrayList[NODES];
        for(int i = 0; i < NODES; i++) adjancyList[i] = new ArrayList<>();
        VISITED = new boolean[NODES];

        for(int i =0; i < EDGES; i++){
            st = new StringTokenizer(br.readLine());
            int argsOne = stringToInt(st.nextToken()), argsTwo = stringToInt(st.nextToken());
            adjancyList[argsOne].add(argsTwo);
            adjancyList[argsTwo].add(argsOne);
        }

        for (int i = 0; i < NODES; i++){
            Arrays.fill(VISITED, false);
            DFS(0, i);
            if (ANSWER) break;
        }

        System.out.println(ANSWER ? 1 : 0);
    }

    /*
    1. depth가 4에 도달한다면 답을 도출한 것이기 때문에 답이다.
    2. 다만 답을 도출한 뒤에 게속 탐색할 이유가 없어서 return 한다.
    3. return 자료형이 따로 없는 것은, 만약 for문에 이어지는 답이 없
    4. 이어진 인접리스트를 보고 이어진 값이 있어서 들어간 뒤에는 true값을 해도 좋다.
    6. 마지막에 현재 값을 굳이 false로 돌려놓는 이유는, 그 다음 탐색에서 답이 아닐 경우 해당 가지를 다시 false처리 해야 하기 때문이다.
     */
    static void DFS(int depth, int target){
        if(depth == 4) {
            ANSWER = true;
            return;
        }
        for (int each : adjancyList[target]) {
            VISITED[target] = true;
            if(!VISITED[each]) DFS(depth + 1, each);
        }
        VISITED[target] = false;
    }

    static int stringToInt(String targetString) {return Integer.parseInt(targetString);}
}
