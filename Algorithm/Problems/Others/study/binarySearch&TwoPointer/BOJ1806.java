import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Main {
 
    public static int arr[];
    public static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        //int minInt = 99999;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int l = 0, r = 0;
        int sum = 0, res = N;
        
        boolean ex = false;
        
        //0번부터 쭉 더하다가 누적합 넘어가면 0번 빼고, 그래도 넘어가면 1번 빼고
        while(true){
            if(sum >= M){
                ex = true;
                res = Math.min(res, r - l);
                sum -= arr[l++];
            }
            else if(r == N) break;
            else sum += arr[r++];
        }
        
        if(ex) System.out.print(res);
        else System.out.print(0);
        
    }

}
