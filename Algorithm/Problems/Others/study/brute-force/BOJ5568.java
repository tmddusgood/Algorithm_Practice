
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Main{
    static int n, k;
    static boolean[] vis;
    static int cards[];
    static Set<Integer> s;

    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        cards = new int[n];
        s = new HashSet<Integer>();
        vis = new boolean[11];
        
        Arrays.fill(vis, false);
        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }
        
        dfs(0, 0);
        
        System.out.println(s.size());
        br.close();

    }
    public static void dfs(int card, int depth){
        if(depth == k){
            s.add(card);
            return;
        }
        for(int i = 0; i < n; i++){
            if(vis[i]) continue;
            vis[i] = true;
            
            int num;
            //자릿수, 두자리 -> *100, 한자리 -> *10
            if(cards[i] >= 10) num = card * 100 + cards[i];
            else num = card * 10 + cards[i];
            
            dfs(num, depth + 1);
            
            vis[i] = false;
        }
    }
}