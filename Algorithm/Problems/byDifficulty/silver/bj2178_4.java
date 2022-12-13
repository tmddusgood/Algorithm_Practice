package acmicpc.book.ing.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 4번쨰 풀었다
// 이제 문제를 보지 않고도 타이핑을 한다 ㅋㅋㅋ
// 총 풀이 시간은 5분 좀 안 되는 듯..
public class bj2178_4 {
    static int ROW;
    static int COLUMN;
    static boolean[][] VISITED;
    static int[][] MATRIX;

    static int[] dRow = {1, 0, 0, -1};
    static int[] dColumn = {0, 1, -1, 0};
    static int dNumber = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COLUMN = Integer.parseInt(st.nextToken());

        MATRIX = new int[ROW][COLUMN];
        for (int i = 0; i < ROW; i++) {
            String line = br.readLine();
            for (int j = 0; j < COLUMN; j++) MATRIX[i][j] = Integer.parseInt(line.substring(j, j + 1));
        }

        VISITED = new boolean[ROW][COLUMN];
        for (boolean[] each : VISITED) Arrays.fill(each, false);

        VISITED[0][0] = true;
        BFS(0, 0);

        System.out.println(MATRIX[ROW - 1][COLUMN - 1]);
    }

    static void BFS(int startRow, int startColumn) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startColumn});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < dNumber; i++) {
                int candRow = current[0] + dRow[i];
                int candColumn = current[1] + dColumn[i];
                if (candRow >= 0 && candColumn >= 0 && candRow < ROW && candColumn < COLUMN) {
                    if (!VISITED[candRow][candColumn] && MATRIX[candRow][candColumn] != 0) {
                        VISITED[candRow][candColumn] = true;
                        MATRIX[candRow][candColumn] = MATRIX[current[0]][current[1]] + 1;
                        queue.offer(new int[]{candRow, candColumn});
                    }
                }
            }
        }
    }
}
