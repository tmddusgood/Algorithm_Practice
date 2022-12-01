package inflearn.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 특정문자뒤집기0105 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> tempStack =new Stack<>();
        char[] inputs = bufferedReader.readLine().toCharArray();
        char[] answer = new char[inputs.length];

        for (char input : inputs ){
            if (input > 65) tempStack.add(input);
        }

        for (int i = 0; i < inputs.length; i++){
            if (inputs[i] > 65) answer[i] = tempStack.pop();
            else answer[i] = inputs[i];
        }

        System.out.println(String.valueOf(answer));
    }
}
