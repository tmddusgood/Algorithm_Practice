package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int i, j;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        
        int max = 0, hd = 0;
        String []str = new String[n];
        
        
        for(i=0;i<n;i++) str[i] = br.readLine();
        
        for(i=0;i<m;i++){
            int a = 0, t = 0, g = 0, c = 0;
        	for(j=0;j<n;j++){
        		switch(str[j].charAt(i)){
        		case 'A' : a++; break;
        		case 'T' : t++; break;
        		case 'G' : g++; break;
        		case 'C' : c++; break;
        		}
        	}
        	max = Math.max(a>c?a:c, g>t?g:t);
        	hd += (n-max);
        	System.out.print(toChar(a,t,g,c,max));
        }
        System.out.println("\n"+hd);
        br.close();

    }
    private static char toChar(int a, int t, int g, int c, int max){
    	if(max==a) return 'A';
    	else if(max==c) return 'C';
    	else if(max==g) return 'G';
    	else return 'T';
    }
}
