import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static StringTokenizer st;

    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[1001][3];
        int[][] rgb = new int[1001][3];
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 1; i <= n; i++)    //0번째는 0이기 때문에 초기화 필요 x
	    {
		    arr[i][0] = Math.min(arr[i - 1][1], arr[i - 1][2]) + rgb[i][0]; // 빨강
		    arr[i][1] = Math.min(arr[i - 1][0], arr[i - 1][2]) + rgb[i][1]; // 초록
		    arr[i][2] = Math.min(arr[i - 1][0], arr[i - 1][1]) + rgb[i][2]; // 파랑
	    }
        
        //3개 중 가장 적은 비용
	    int minNum = 
            (arr[n][1] > arr[n][0]) && (arr[n][2] > arr[n][0]) 
            ? arr[n][0]
            : (arr[n][1] > arr[n][2]
               ? arr[n][2]
               :arr[n][1]);

        System.out.println(minNum);
    }
}