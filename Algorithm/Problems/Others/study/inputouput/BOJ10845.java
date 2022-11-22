// 큐 (백준 10845번)
package boj_Q10845;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class boj_Q10845 {
	static public void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int len = input.nextInt();
		Deque<Integer> deque = new LinkedList<>();
		StringBuffer output = new StringBuffer();
		
		for(int i=0; i<len; i++) {
			String str = input.next();  //String
			
			switch(str) {
			
			case "push":
				deque.add(input.nextInt());
				break;
				
			case "pop":
				if(deque.isEmpty()) output.append(-1).append('\n');
				else output.append(deque.poll()).append('\n');
				break;
			
			case "size":
				output.append(deque.size()).append('\n');
				break;
			
			case "empty":
				if(deque.isEmpty()) output.append(1).append('\n');
				else output.append(0).append('\n');
				break;
			
			case "front":
				if(deque.isEmpty()) output.append(-1).append('\n');
				else output.append(deque.peek()).append('\n');
				break;
			
			case "back":
				if(deque.isEmpty()) output.append(-1).append('\n');
				else output.append(deque.peekLast()).append('\n');
				break;
				
			}
		}
		input.close();
		System.out.println(output);
	}
}