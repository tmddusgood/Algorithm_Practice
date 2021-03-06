import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4344 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        int caseNum = Integer.parseInt(bufferedReader.readLine());

        for(int i=0; i<caseNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int studentNum = Integer.parseInt(stringTokenizer.nextToken());
            int[] scoreArray = new int[studentNum];

            int total = 0;
            for (int j=0; j<studentNum; j++) {
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                total += temp;
                scoreArray[j] = temp;
            }

            double average = (double)total / studentNum;

            int higherAverageCount = 0;

            for (int temp : scoreArray){
                if ((double)temp > average){
                    higherAverageCount += 1;
                }
            }

            double resultPortion = (double) higherAverageCount / studentNum * 100;

            stringBuilder.append(String.format("%.3f", resultPortion)).append("%").append('\n');
        }
        System.out.println(stringBuilder);
    }
}
