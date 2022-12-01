import java.util.*;
import java.io.*;
 
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int target = Integer.parseInt(br.readLine());
        
        int cnt = 0;
        int left = 0;
        int right = n-1;
        
        while(left < right){
            int sum = input[left] + input[right];
            if(sum == target){
                //한 칸씩 안쪽으로 당김
                left++;
                right--;
                
                cnt++;
            }else if(sum > target)
                right--;
            else
                left++;
        }
        System.out.println(cnt);
    }
}