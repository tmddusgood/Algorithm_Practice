import java.util.*;
import java.io.*;

public class Main{
    static int parent[];
    static int root;
    static int depth(int a){
        int count = 0;
        while(a != root){
            a = parent[a];
            count++;
        }
        return count;
    }
    
    static int find(int first_depth, int second_depth, int a, int b){
        while(first_depth > second_depth){
            first_depth--;
            a = parent[a];
        }
        while(first_depth < second_depth){
            second_depth--;
            b = parent[b];
        }
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());
            parent = new int[n+1];
            boolean child[]= new boolean[n+1];
            
            for(int i = 0; i < n-1; i++){
                String input[] = br.readLine().split(" ");
                parent[Integer.parseInt(input[1])] = Integer.parseInt(input[0]);
                child[Integer.parseInt(input[1])] = true;
            }
            
            for(int i = 1; i <= n; i++){
                if(!child[i]){
                    root = i;
                    break;
                }
            }
            
            String target[] = br.readLine().split(" ");
            int a = Integer.parseInt(target[0]);
            int b = Integer.parseInt(target[1]);
            
            int first_depth = depth(a);
            int second_depth = depth(b);
            
            System.out.println(find(first_depth, second_depth, a, b));
        }
    }
}