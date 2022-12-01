import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main{
    static int N;
	static int[] arr; // 각 index의 부모노드
	static boolean[] del; 
	
	static void delete(int start) {
		del[start] = true;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int tmp_parent = queue.poll();
			for(int i=0; i<N; i++) {
				//tmp_parent = i의 부모?
				if(tmp_parent == arr[i] && !del[i]) {
					del[i] = true; // i를 삭제하고
					queue.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		del = new boolean[N];
		HashSet<Integer> parents = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			del[i] = false;
		}
		
		int remove = Integer.parseInt(br.readLine());
		
		delete(remove);
		
		for(int i=0; i<N; i++) {
			//부모 노드를 조사하여 무시할 것(부모노드라는 것은 리프노드가 아니라는 것)
			if(!del[i] && arr[i] >= 0) {
                //부모 리스트에 추가
				parents.add(arr[i]); 
			}
		}
		
		
        //부모 노드, 삭제된 노드들 무시하고 카운트
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(!del[i] && !parents.contains(i)) {
				++cnt;
			}
		}
		
		System.out.println(cnt);
	}
	
}
