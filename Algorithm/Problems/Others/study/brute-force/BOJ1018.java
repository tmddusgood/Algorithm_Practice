package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static char[][] compBoard = new char[8][8];
	static char[][] black = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};
	static char[][] white = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
				, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
				, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int min = 64;
		board = new char[m][n];
		
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
			}
		}
		//입력 끝
        
        //현재 좌표로부터 가로 세로 8개씩 다른 갯수 확인
		for (int i = 0; i <= m-8; i++) {
			for (int j = 0; j <= n-8; j++) {
				min = getMin(i, j, min);
			}

		}
		
		System.out.println(min);
	}
	
	public static int getMin(int y, int x, int min) {
		int cntB = 0;
		int cntW = 0;
		int k = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = y; i < y+8 ; i++) {
			sb.setLength(0);
			
			for (int j = x; j < x+8; j++) {
				sb.append(board[i][j]);
			}
			
			for (int j = 0; j < sb.length(); j++) {
				compBoard[k][j] = sb.charAt(j);
			}
			k++;
		}
		System.out.println(k);
   
		for (int i = 0; i < compBoard.length; i++) {
			for (int j = 0; j < compBoard[i].length; j++) {
				if(compBoard[i][j] != black[i][j]) cntB++;
				if(compBoard[i][j] != white[i][j]) cntW++;
			}
		}
		
		return Math.min(Math.min(cntW, cntB), min);
	}
	
}
