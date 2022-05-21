package temp;

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int arrivalTime = timeToInt("09:00");
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String time : timetable) queue.add(timeToInt(time));

        // 막차일 때까지
        int leftBus = 0;
        while (leftBus <= n - 1) {
            // 도착시간 추가
            if (leftBus != 0) arrivalTime += t;

            // 기다리는 사람들이 있고, 자리가 남아있는 동안
            int occupied = 0;
            while (queue.size() != 0 && occupied <= m - 1) {
                // 마지막으로 온 사람이 도착시간을 지나서 왔다면 break
                if (queue.peek() > arrivalTime) {
                    break;
                }

                // 막차, 자리 없으면 마지막으로 온 사람보다 1분 빠르게
                if (occupied == m - 1 && leftBus == n - 1) {
                    return timeToStr(queue.poll() - 1);
                }

                // 모두 해당사항 없다면 일반적인 경우, 빼서 버린다.
                queue.poll();

                // 빼서 버리니까 자리는 하나 찼다.
                occupied++;
            }
            leftBus++;
        }
        //막차에 탈 수 있는 경우
        return timeToStr(arrivalTime);
    }

    static int timeToInt(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    static String timeToStr(int time) {
        return String.format("%02d", time / 60) + ":" + String.format("%02d", time % 60);
    }
}