import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;
    static ArrayList<VtxCst>[] list;
    static int v, e, s;
    static int[] dist;
    static int res = 50000;
    
    static class VtxCst implements Comparable<VtxCst>{
        int vtx;
        int cst;
        public VtxCst(int cst, int vtx){
            this.cst = cst;
            this.vtx = vtx;
        }
        @Override
        public int compareTo(VtxCst v1){
            if(this.cst > v1.cst) return 1;
            else return -1;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
       
        s = Integer.parseInt(br.readLine());
        
        list = new ArrayList[v+1];
        for(int i = 0; i < v+1; ++i){
            list[i] = new ArrayList<VtxCst>();
        }
        dist = new int[20001];
        
        for(int i = 1; i <= e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new VtxCst(cost, b));
        }
        
        dijkstra();
    }
    public static void dijkstra(){
        for(int i = 1; i <= v; i++){
            dist[i] = 9999999;
        }
        dist[s] = 0;
        
        PriorityQueue<VtxCst> pq = new PriorityQueue<>();
        
        pq.add(new VtxCst(0, s));
        
        while(!pq.isEmpty()){
            int cost = pq.peek().cst;
            int vertex = pq.peek().vtx;
            pq.remove();
            
            if(dist[vertex] < cost) continue;
            
            for(int i = 0; i < list[vertex].size(); ++i){
                int nVtx = list[vertex].get(i).vtx;
                int nCst = cost + list[vertex].get(i).cst;

                if(dist[nVtx] > nCst){
                    dist[nVtx] = nCst;
                    pq.add(new VtxCst(nCst, nVtx));
                }
            }
        }
        
        for(int i = 1; i <= v; i++){
            if(s == i) System.out.println("0");
            else if(dist[i] == 9999999) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}