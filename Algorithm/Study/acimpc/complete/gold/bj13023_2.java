package acmicpc.book.complete.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj13023_2 {
    static ArrayList<Integer>[] MAP;
    static int EDGES;
    static int NODES;
    static boolean ANSWER = false;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        // 기본 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        NODES = Integer.parseInt(st.nextToken());
        EDGES = Integer.parseInt(st.nextToken());

        // 첫 필터링

        // 필요 배열 초기화하고
        MAP = new ArrayList[NODES];
        VISITED = new boolean[NODES];
        for (int i = 0; i < NODES; i++) MAP[i] = new ArrayList<>();

        // 친구 관계 채워준다.
        for (int i = 0; i < EDGES; i++) {
            st = new StringTokenizer(br.readLine());
            int friendA = Integer.parseInt(st.nextToken()), friendB = Integer.parseInt(st.nextToken());
            MAP[friendA].add(friendB);
            MAP[friendB].add(friendA);
        }

        // 시작점 정하기
        for (int i = 0; i < NODES; i++) {
            Arrays.fill(VISITED, false);
            DFS(0, i);
            if (ANSWER) break;
        }

        System.out.println(ANSWER ? 1 : 0);
    }

    public static void DFS(int depth, int currentAt) {
        if (depth == 4) {
            ANSWER = true;
            return;
        }

        VISITED[currentAt] = true;

        for (int each : MAP[currentAt]) {
            if (!VISITED[each]) DFS(depth + 1, each);
        }

        // 여기까지 왔다면 함수가 종료되지 않았고, 마지막으로 방문한 애는 의미가 없으므로
        // 근데 그러면 결국.. 답을 못 찾았다는 건데.
        // 그럼 이 안에서 돌던 for문 때문에 생긴 visited는 다시 초기화를 시켜줘야지
        VISITED[currentAt] = false;
    }
}




