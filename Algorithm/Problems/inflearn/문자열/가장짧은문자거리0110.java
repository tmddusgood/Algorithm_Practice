package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 가장짧은문자거리0110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        char[] inputs = bufferedReader.readLine().toCharArray();
        ArrayList<Integer> positionList = new ArrayList<>();

        for (int i = 0; i < inputs.length - 2; i++) {
            if (inputs[i] == inputs[inputs.length - 1]) positionList.add(i);
        }

        for (int i = 0; i < inputs.length - 2; i++) {
            int min = Integer.MAX_VALUE;
            for (int targetPos : positionList) {
                int distance = Math.abs(targetPos - i);
                if (distance <= min) min = distance;
            }
            stringBuilder.append(min).append(" ");
        }

        System.out.println(stringBuilder);
    }
}
