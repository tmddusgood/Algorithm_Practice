import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    
    public static int N, C;
    public static int arr[];

 
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            arr[i] = Integer.parseInt(st.nextToken().trim());
        }
 
        Arrays.sort(arr);

        int left = 1;
        int right = arr[N-1] - arr[0];

        int result = 0;


        while (left <= right) {
            int mid = (left + right)/2;
            int left_tmp = arr[0];
            int cnt = 1;//공유기 갯수(맨 왼쪽집에 하나 설치하고 시작해서 1)

            for (int i=1; i<N; i++) {
                if (arr[i]-left_tmp >= mid) {
                    //간격
                    cnt++;
                    left_tmp = arr[i];
                }
            }

            if (cnt >= C) {
                result = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        System.out.println(result);
    }
}