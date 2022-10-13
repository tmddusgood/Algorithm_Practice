import java.util.*;
import java.io.*;

public class Main{
    public static int N;
    public static int cnt;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        recursive(N, 1, 2, 3);
        System.out.println(cnt);
        System.out.println(sb);
    }
    
    public static void recursive(int n, int start, int sub, int end){
        if(n == 1){
            cnt++;
            sb.append(start + " " + end + '\n');
            return;
        }
        //
        recursive(n-1, start, end, sub);
        recursive(1, start, sub, end);
        recursive(n-1, sub, start, end);
    }

}