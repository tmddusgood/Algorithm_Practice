import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;
public class Main {
    
	public static int N, M;
    public static boolean[] vis = new boolean[8];
    public static int[] arr = new int[8];
    public static StringBuilder sb = new StringBuilder();
    
	static void recursive(int tmp, int count, List<Integer> list) throws IOException {
		vis[tmp] = true;
        list.add(tmp);
        
        if(count == M){
            //for(int i = 0; i< list.size(); i++){
            //    System.out.print(list.get(i) + " ");
            //}
            System.out.print(list.get(0) + " " + list.get(list.size()-1) + '\n');
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(vis[i] == false){
                recursive(i, count+1, list);
                vis[i] = false;
            }
        }
	}
	
    public static void recursive2(int x){
        if(x == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append('\n');
        }
        
        for(int i = 0; i < N; i++){
            if(!vis[i]){    //유망한지에 대한 체크, 이미 방문한적이 있다면 
                            //중복 없는수열을 만들 수 없다
                vis[i] = true;
                arr[x] = i + 1;
                
                recursive2(x + 1);
                
                vis[i] = false;
            }
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
		
        
        recursive2(0);
		// for(int i = 1; i < N; i++){
		// vis = new boolean[10];
		// List<Integer> list = new ArrayList<>();
		// recursive(i, 1, list);
		// }
        System.out.println(sb);
	}
}