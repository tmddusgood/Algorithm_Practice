import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2577_2{
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int resultNum = Integer.parseInt(bufferedReader.readLine())
                * Integer.parseInt(bufferedReader.readLine())
                * Integer.parseInt(bufferedReader.readLine());

        String resultNumStr = String.valueOf(resultNum);
        int[] countArray = new int[10];

        for (int i=0; i < resultNumStr.length(); i ++){
            countArray[resultNumStr.charAt(i) - '0']++;
        }

        for (int v : countArray){
            System.out.println(v);
        }

    }
}