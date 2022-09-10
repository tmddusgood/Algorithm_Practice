package acmicpc.stepbystep.function;

public class bj4673 {
    static boolean[] result = new boolean[10036];
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            int sum = i;
            int pointer = i;
            while(pointer > 0) {
                sum += pointer % 10;
                pointer /= 10;
            }
            result[sum] = true;
            if (!result[i]) stringBuilder.append(i).append("\n");
        }
        System.out.println(stringBuilder);
    }
}
