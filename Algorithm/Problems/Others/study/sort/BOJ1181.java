import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int N = Integer.parseInt(br.readLine());
 
        String[] arr = new String[N];
 
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        // Comparator 오름차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() - s2.length() == 0) { // 길이가 같으면
                    return s1.compareTo(s2); // 사전순
                }
                // 길이가 다르면
                return s1.length() - s2.length(); // 길이순
            }
        });
 
        for (int i = 0; i < N; i++) {
            if (i + 1 != N) {
                if (arr[i].equals(arr[i + 1])) { // 현재 인덱스와 다음 인덱스에 해당하는 요소가 같은지 확인.
                    continue;
                }
            }
            bw.write(arr[i] + "\n");
        }
 
        bw.flush();
        bw.close();
        br.close();
    }
 
}
