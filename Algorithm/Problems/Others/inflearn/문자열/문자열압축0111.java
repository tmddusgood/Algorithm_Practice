package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열압축0111 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = bufferedReader.readLine().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        int combo = 1;
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i - 1] == inputs[i]) combo++;
            else if (combo > 1) {
                stringBuilder.append(inputs[i - 1]).append(combo);
                combo = 1;
            } else stringBuilder.append(inputs[i - 1]);
        }

        stringBuilder.append(inputs[inputs.length - 1]);
        if (combo > 1) stringBuilder.append(combo);

        System.out.println(stringBuilder);
    }
}
