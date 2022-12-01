import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        
        int[] arr; 
        StringBuilder sb = new StringBuilder(); 
        
        while(t-- > 0) { 
            int first = sc.nextInt(); 
            arr = new int[first]; 
            for(int i = 0;i < first; i++) { 
                arr[i] = sc.nextInt(); 
            } 
            
            Arrays.sort(arr); 
            int second = sc.nextInt(); 
            for(int i = 0; i < second; i++) { 
                sb.append(Arrays.binarySearch(arr, sc.nextInt()) > -1 ? "1\n" : "0\n"); 
            } 
        } 
        System.out.println(sb.toString()); 
    }

}