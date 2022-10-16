import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int res = 0;
        //1                1
        //1 2              3
        //1 2 3            6
        //1 2 3 3          9
        //1 2 3 3 4        13    =>32
        for (int i = 0; i < n; i++){
            res += arr[i] * (n - i);
        }

        System.out.println(res);
    }
}