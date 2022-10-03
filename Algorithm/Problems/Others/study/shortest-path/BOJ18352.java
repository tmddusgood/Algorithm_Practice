//bfs
//거리마다 방문할 수 있는 정점이 다르므로 크기 저장
//단방향, 노드 연결상태 저장
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;
    static ArrayList<Integer>[] list;
    static int n, m, k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[n+1];
        
        for (int i = 0; i < list.length; i++) { 
            list[i] = new ArrayList<Integer>(); 
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }
        bfs(start);
    }
    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        int lim = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        while(!q.isEmpty()){
            int qSize = q.size();
            while(qSize-- > 0){
                int cur = q.poll();
                if(lim == k)
                    res.add(cur);
                for(int next: list[cur]){
                    if(visited[next] == false){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            lim++;
            if(lim > k)
                break;
        }
        if(res.isEmpty()){
            System.out.println(-1);
        }
        Collections.sort(res);
        for(int con: res)
            System.out.println(con);
    }
}