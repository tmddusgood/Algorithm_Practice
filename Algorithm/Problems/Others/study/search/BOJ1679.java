 
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;


public class Main { 
    public static void main(String[] args) throws IOException{ 
        int n,k; BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String input = br.readLine(); 
        n = Integer.parseInt(input.split(" ")[0]); 
        k = Integer.parseInt(input.split(" ")[1]);
        
        int[] dist = new int[100001]; 
        
        Queue<Integer> q = new LinkedList<Integer>(); 
        q.add(n); 
        
        while (! q.isEmpty()) { 
            int tmp = q.poll(); 
            if(tmp == k) { 
                System.out.println(dist[tmp]); 
                return; 
            } 
            // 하나 +
            if(tmp+1 < 100001 && dist[tmp + 1] == 0){ 
                q.add(tmp + 1); 
                dist[tmp + 1] = dist[tmp] + 1; 
            } 
            // 하나 - 
            if(tmp - 1 >= 0 && dist[tmp - 1] == 0){ 
                q.add(tmp - 1); 
                dist[tmp - 1] = dist[tmp] + 1; 
            } 
            // 2배이동 
            if(2 * tmp < 100001 && dist[2 * tmp] == 0){ 
                q.add(2 * tmp); 
                dist[2 * tmp] = dist[tmp] + 1; 
            } 
        }
    } 
}


