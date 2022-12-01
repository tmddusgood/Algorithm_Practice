 
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Scanner scan = new Scanner(System.in);
        
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            //scan.nextLine();
            
            String[] nums = new String[n];
            for(int j = 0; j < n; j++) {
                nums[j] = br.readLine();
            }
            Arrays.sort(nums);
            
            boolean isInclude = true;
            for(int j = 1; j < n; j++) {
                if(nums[j].startsWith(nums[j - 1])) {
                    isInclude = false;
                    break;
                }
            }
            if(isInclude == false) System.out.println("NO");
            else System.out.println("YES");
        }
    }
	
}