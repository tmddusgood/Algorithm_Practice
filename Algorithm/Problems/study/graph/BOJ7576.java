import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

public class Main {
    static class Pos{
	int y;
	int x;
	public Pos(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
	static int m,n;
	static int[][] map;
	static int[] xpos= {1,-1,0,0};
	static int[] ypos= {0,0,1,-1};
    
	static Queue<Pos> q = new LinkedList<Pos>();
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

		map=new int[n][m];
		for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j ] == 1)q.add(new Pos(i,j));
			} 
		}
		int time=0;
		while(q.size()!=0) {
			int len=q.size();
			
			for (int i = 0; i < len; i++) {
				Pos cur = q.poll();
				int y = cur.y;
				int x = cur.x;
				
				for (int k = 0; k < 4; k++) {
					int ny = y + ypos[k];
					int nx = x + xpos[k];
					if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
					if(map[ny][nx] == 1 || map[ny][nx] == -1) continue;
					map[ny][nx] = 1;
					q.add(new Pos(ny,nx));
				}
			}
			if(q.size()!=0) time++;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					time = -1;
					break;
				}
			}
		}
		
		System.out.println(time);
		
	}
}