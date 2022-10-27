 
import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;
public class Main {
    
	public static int N;
    public static int[] op;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> list = new ArrayList<>();
    
    public static void dfs(int depth, int tmp){
        if(depth == N){
            list.add(tmp);
        }
        for(int i = 1; i <= 4; i++){
            if(op[i] == 0)continue;
            
            if(i == 1){
                op[i]--;
                dfs(depth + 1, tmp + arr[depth + 1]);
                op[i]++;
            }
            if(i == 2){
                op[i]--;
                dfs(depth + 1, tmp - arr[depth + 1]);
                op[i]++;
            }
            if(i == 3){
                op[i]--;
                dfs(depth + 1, tmp * arr[depth + 1]);
                op[i]++;
            }
            if(i == 4){
                op[i]--;
                dfs(depth + 1, tmp / arr[depth + 1]);
                op[i]++;
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[12];
        op = new int[6];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(1, arr[1]);
		
        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

	}
}