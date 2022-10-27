package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main {
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static int x,y;
	static int board[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		 
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		board = new int[x][y];
		int dist[][]= new int[x][y];
		
        //queue 삽입
		Queue<Shark> q = new LinkedList<>();
		for(int i=0; i<x; i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0; j<y; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = Integer.MAX_VALUE;
				if(board[i][j]==1) {
					q.add(new Shark(i,j));
					dist[i][j]=0;
				}
			}
		}//insert
		
		//sol
		int max = 0;
		while(!q.isEmpty()) {
			Shark cur =q.poll();
			
			for(int i=0; i<8; i++) {
			int nx = cur.x + dx[i];
			int ny = cur.y + dy[i];
			
			    if(nx>=0 && ny>=0 && nx<x && ny<y) {
				    if(dist[nx][ny] > dist[cur.x][cur.y]+1) {
				    	dist[nx][ny] = dist[cur.x][cur.y]+1;
				    	q.add(new Shark(nx,ny));
				    	max = Math.max(dist[nx][ny], max);
				    }
			    }
			
			}
			
		}
		
		System.out.println(max);
	}
 
	
}

class Shark{
	int x,y;

	public Shark(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
