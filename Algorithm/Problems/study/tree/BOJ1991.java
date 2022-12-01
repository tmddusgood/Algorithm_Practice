import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;

class Node{ 
    int index; 
    Node parent; 
    Node leftchild; 
    Node rightchild; 
    
    public Node(int index) { 
        super(); 
        this.index = index;
    } 
} 
public class Main { 
    static Node[] tree; 
    private static void PostOrder(int cur) { 
        //왼쪽 노드
        if(tree[cur].leftchild != null) 
            PostOrder(tree[cur].leftchild.index); 
        //오른쪽 노드
        if(tree[cur].rightchild != null) 
            PostOrder(tree[cur].rightchild.index); 
        //자신 노드
        System.out.print((char)(tree[cur].index+'A')); 
    }
    
    private static void inOrder(int cur) { 
        //왼쪽 노드
        if(tree[cur].leftchild != null) 
            inOrder(tree[cur].leftchild.index); 
        //자신 노드
        System.out.print((char)(tree[cur].index+'A')); 
        //오른쪽 노드
        if(tree[cur].rightchild != null) 
            inOrder(tree[cur].rightchild.index); 
    } 
    
    private static void preOrder(int cur) { 
        //자신 노드
        System.out.print((char)(tree[cur].index+'A')); 
        //왼쪽 노드
        if(tree[cur].leftchild != null) 
            preOrder(tree[cur].leftchild.index); 
        //오른쪽 노드
        if(tree[cur].rightchild != null) preOrder(tree[cur].rightchild.index); 
    } 
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int N = Integer.parseInt(st.nextToken()); 
        tree = new Node[N]; 
        for (int i = 0; i < N; i++) { 
            tree[i] = new Node(i); 
        } 
        for (int i = 0; i < N; i++) { 
            st = new StringTokenizer(br.readLine()); 
            int node = st.nextToken().charAt(0)-'A'; 
            int left = st.nextToken().charAt(0)-'A'; 
            int right = st.nextToken().charAt(0)-'A'; 
            
            if(left >= 0)
                tree[node].leftchild = tree[left]; 
            if(right >= 0)
                tree[node].rightchild = tree[right]; 
            if(left >= 0) 
                tree[left].parent = tree[node]; 
            if(right >= 0)
                tree[right].parent = tree[node]; 
        } 
        
        preOrder(0); 
        System.out.println(); 
        inOrder(0); 
        System.out.println(); 
        PostOrder(0); 
    } 
    
}
