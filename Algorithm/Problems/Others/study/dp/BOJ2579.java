
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[301][2];
        int[] stairs = new int[301];
        
        for(int i = 0; i < n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        
        arr[0][0] = stairs[0];
	    arr[1][0] = stairs[1];
        arr[1][1] = stairs[0] + stairs[1];
        
        for (int i = 2; i < n; i++) {
		    arr[i][0] = Math.max(arr[i - 2][0], arr[i - 2][1]) + stairs[i];
		    arr[i][1] = arr[i - 1][0] + stairs[i];
        }
	
        System.out.println(Math.max(arr[n-1][0], arr[n-1][1]));
    }
}