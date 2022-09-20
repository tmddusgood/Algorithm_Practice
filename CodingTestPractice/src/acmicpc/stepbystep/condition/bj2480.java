package acmicpc.stepbystep.condition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// 해시맵, 어레이 to 어레이리스트 변환
public class bj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] givens = bufferedReader.readLine().split(" ");

        Integer[] givensInt = new Integer[givens.length];
        for ( int i = 0; i < givens.length; i++ ) givensInt[i] = Integer.parseInt(givens[i]);

        HashMap<Integer, Integer> givenMap = new HashMap<>();
        for (Integer each : givensInt){
            if(givenMap.containsKey(each)) givenMap.put(each, givenMap.get(each) + 1);
            else givenMap.put(each, 1);
        }

        for (Map.Entry<Integer, Integer> each : givenMap.entrySet()){
            if (each.getValue() == 3) {
                System.out.println(10000 + each.getKey() * 1000);
                return;
            }
            else if (each.getValue() == 2){
                System.out.println(1000 + each.getKey() * 100);
                return;
            }
        }
        System.out.println(Collections.max(new ArrayList<>(Arrays.asList(givensInt))) * 100);
    }
}
