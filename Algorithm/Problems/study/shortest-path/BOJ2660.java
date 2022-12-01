//플로이드 워셜
//모든 정점 -> 모든 정점
//모든 정점에서 모든 정점 사이의 최단거리
//i -> j 최소간선 업데이트
//가장 먼 사람과의 점수를 tmp에 업데이트 => res 갱신
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;
    static ArrayList<Integer> list;
    static int n, m, k;
    static int[][] dist = new int[51][51];
    static int res = 50000;
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                dist[i][j] = 1000;
            }
        }
        
        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a + b == -2) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }
        
        for(int t=1;t<=n;t++)
            for(int i=1;i<=n;i++)
                for(int j=1;j<=n;j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][t] + dist[t][j]);
        
        list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int tmp = 0;
            for(int j = 1; j <= n; j++){
                tmp = Math.max(tmp, dist[i][j]);
            }
            if(tmp < res){
                list.clear();
                res = tmp;
                list.add(i);
            }else if(tmp == res){
                list.add(i);
            }
        }
        
        Collections.sort(list);
        
        System.out.println(res + " " + list.size());
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i)+" ");
        
    }
}