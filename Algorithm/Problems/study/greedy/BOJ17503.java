 
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        ArrayList<Pair> list = new ArrayList(k+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int prefer = Integer.parseInt(st.nextToken());
            int alch = Integer.parseInt(st.nextToken());
            list.add(new Pair(alch, prefer));
        }
        
        //알콜레벨 순으로 sort (3, 3) (3, 4) (4, 1) (5, 2) (6, 4)
        Collections.sort(list);
        //for(int i = 0; i < k; i++){
        //    System.out.println(list.get(i).x + ", " + list.get(i).y);
        //}
        int prefer_sum = 0;
        int res = -1;
        for(int i = 0; i < k; i++){
            pq.add(list.get(i).y);
            prefer_sum += list.get(i).y;
            
            //맥주의 수가 기간보다 많으면 선호도가 가장 낮은거 컷
            if(pq.size() > n){
                prefer_sum -= pq.poll();
            }
            
            //날에 맞춰 먹었고, 목표치 충당한경우
            if(pq.size() == n && prefer_sum >= m){
                res = list.get(i).x;
                break;
            }
        }
        System.out.println(res);

    }
    
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair p) {
            if (this.x < p.x) {
                return -1;
            } else if (this.x > p.x) {
                return 1;
            }else{
                if(this.y < p.y) return -1;
                else if(this.y > p.y) return 1;
            }
            return 0;
        }
    }
}