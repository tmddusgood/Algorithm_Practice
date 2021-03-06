import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;
        String tempString;

        while ((tempString = bufferedReader.readLine()) != null){
            stringTokenizer = new StringTokenizer(tempString);

            int numberA = Integer.parseInt(stringTokenizer.nextToken());
            int numberB = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(numberA + numberB).append("\n");
        }

        System.out.println(stringBuilder);
    }
}