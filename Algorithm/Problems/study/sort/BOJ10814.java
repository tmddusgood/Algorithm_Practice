// 나이순 정렬 (백준 10814번)
// 람다식, comparator || comparable 이용

package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class Q10814 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		String[][] arr = new String[count][2];
		int i=0;

		while(i<count) {
			String str = br.readLine();
			String parts[] = str.split(" ");
			arr[i][0] = parts[0]; //age
			arr[i][1] = parts[1]; //name
			i++;
		}
		
		Arrays.sort(arr, (a, b)-> Integer.valueOf(a[0]).compareTo(Integer.valueOf(b[0])));
		//Arrays.sort(arr, (a, b)-> Integer.parseInt(a[0]) - Integer.parseInt(b[0]));
		/*
		Arrays.sort(arr, new Comparator<String[]>() {	
	          @Override
	          public int compare(String[] s1, String[] s2) {
	            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
	          }
	    });*/
		for(int z = 0; z < count; z++) {
			System.out.println(arr[z][0] + " " + arr[z][1]);
		}
	}
}