import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[1001];
        int[] seq = new int[1001];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            seq[i] = 1;
        }
        
        int max_num = -11111;
        for(int i = 0; i < n; i++){    // 10 20 10 30 40 20
                                        // 1  2  2  3  4  4
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && seq[i] < seq[j]+1){
                    ++seq[i];
                }
            }
            if(max_num < seq[i])
                max_num = seq[i];
        }
        
        System.out.println(max_num);
    }
}