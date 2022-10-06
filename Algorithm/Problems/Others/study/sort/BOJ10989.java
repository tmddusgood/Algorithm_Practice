package bingoring.sort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int number = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];

        for(int i = 0; i < number; i++){
            arr[Integer.parseInt(br.readLine())] ++;
        }
        br.close();

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > 0){
                for(int x = 0; x < arr[i]; x++){
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    } 
}