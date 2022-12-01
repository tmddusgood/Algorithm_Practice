// 벽 부수고 이동하기 (백준 2206번)

/* [ 알고리즘 ]
 * 
 * 1. 먼저 전체 맵을 받아 이차원 배열에 저장
 * 2. 처음 (0,0) 칸부터 시작해서 상하좌우로 이동 (현재 위치에서 4가지 방향으로 가는 반복문) - 현재 위치 & distance & 벽을 부순 횟수를 추가.
 * 3. 만약 맵을 벗어나는 경우 continue
 * 4. 만약 이미 드릴을 사용했는데 또 벽일 경우 continue
 * 5. 3번과 4번이 모두 아닐 경우 두가지 케이스로 나눠서 이동
 * 6. (1) 이동한 좌표가 0일 경우 : 이동거리 증가, 드릴횟수 그대로
 * 7. (2) 이동한 좌표가 1일 경우 : 이동거리 증가, 드릴횟수 증가
 * 8. 만약 이동한 좌표가 (N-1,M-1) 이 될 경우 그때의 이동거리 return
 * 9. 모든 경우가 끝났을 경우 해당 이동거리를 출력, 이동거리가 0이면 -1을 출력 
 * 
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Q2206 {
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
 
    static class Point {
        int x, y, distance;
        int drill; // 공사 횟수
 
        public Point(int x, int y, int distance, int drill) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.drill = drill;
        }
    }
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
 
        map = new int[N][M];
        visited = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
 
        int ans = bfs(0, 0);
        bw.write(ans + "\n");
 
        bw.flush();
        bw.close();
        br.close();
    }
 
    private static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 1, 0)); 
        visited[y][x] = 0; 
 
        while (!q.isEmpty()) {
            Point point = q.poll();
 
            if (point.x == M - 1 && point.y == N - 1)
                return point.distance;
 
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
 
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (visited[ny][nx] > point.drill) {
                        if (map[ny][nx] == 0) { // 벽이 아닐 때
                            q.add(new Point(nx, ny, point.distance + 1, point.drill));
                            visited[ny][nx] = point.drill;
                        } else { // 벽일 때
                            if (point.drill == 0) { // 지금까지 벽을 부순 횟수가 0이라면 
                                q.add(new Point(nx, ny, point.distance + 1, point.drill + 1));
                                visited[ny][nx] = point.drill + 1;
                            }
                        }
                    }
                }
            }
        }
 
        return -1;
    }
}