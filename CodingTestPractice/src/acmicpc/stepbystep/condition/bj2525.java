package acmicpc.stepbystep.condition;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class bj2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] times = bufferedReader.readLine().split(" ");

        int requiredTime = Integer.parseInt(bufferedReader.readLine());
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);

        hour = (hour + ((minute + requiredTime) / 60)) % 24;
        minute = ((minute + requiredTime) % 60);

        System.out.println(hour + " " + minute);
    }
}
