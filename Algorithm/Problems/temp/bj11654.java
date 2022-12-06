import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = bufferedReader.readLine();
        System.out.println(inputStr.charAt(0) - 0);
    }
}