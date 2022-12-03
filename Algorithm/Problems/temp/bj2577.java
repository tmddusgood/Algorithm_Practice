import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] numArray= new String[3];

        for (int i = 0; i < 3; i ++){
            String tempNum = bufferedReader.readLine();
            numArray[i] = tempNum;
        }

        int resultNum = Integer.parseInt(numArray[0]) * Integer.parseInt(numArray[1]) * Integer.parseInt(numArray[2]);

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