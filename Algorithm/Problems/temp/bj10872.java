import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class P10872 {
    static int factorial(int number){
        if(number == 1){
            return number;
        }
        else if(number == 0){
            return 1;
        }
        return number * factorial(number - 1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        System.out.println(factorial(number));
    }
}