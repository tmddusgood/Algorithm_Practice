import java.io.*;
import java.util.StringTokenizer;

public class P11022 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        int caseCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < caseCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int numA = Integer.parseInt(stringTokenizer.nextToken());
            int numB = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder
                    .append("Case #")
                    .append(i + 1)
                    .append(": ")
                    .append(numA)
                    .append(" + ")
                    .append(numB)
                    .append(" = ")
                    .append(numA + numB)
                    .append("\n");
        }

        System.out.println(stringBuilder);
    }
}