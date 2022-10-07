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
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            //minInt = Math.min(arr[i], minInt);
        }
        Arrays.sort(arr);
        System.out.println(binarySearch(M, 1, arr[N-1]));
    }
    
    static long binarySearch(int key, long low, long high) {
		long mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
            
            int tmp_sum = 0;
			for (int i = 0; i < N; i++) { 
                tmp_sum += arr[i] / mid; 
            }

			if(M <= tmp_sum) {
                low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return high;
	}
}
