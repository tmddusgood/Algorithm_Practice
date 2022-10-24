import java.util.*;
import java.io.*;
import java.util.List;
import java.util.Vector;


public class Main {
    
	public static int N, M;
    public static StringBuilder sb;
    public static ArrayList<Pos> listHouse = new ArrayList<>();
    public static ArrayList<Pos> listChicken = new ArrayList<>();
    public static ArrayList<Pos> listChosenChicken = new ArrayList<>();
    public static boolean[] vis;
    public static int res_distance = 9999999;
    
    public static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void chooseChicken(int chicken_idx, int depth){
        //depth = 선택한 치킨집의 개수, 치킨집을 모두 선택한 경우 실행
        if(depth == M){
            int distance = 0;
            for(int i = 0; i < listHouse.size(); i++){
                int tmp_dis = 9999999;
                for(int j = 0; j < listChosenChicken.size(); j++){
                    tmp_dis = Math.min(tmp_dis, 
                                   Math.abs(listHouse.get(i).x - listChosenChicken.get(j).x) +
                                      Math.abs(listHouse.get(i).y - listChosenChicken.get(j).y));
                }
                distance += tmp_dis;
            }
            res_distance = Math.min(res_distance, distance);
            return;
        }
        
        //치킨집 선택
        for(int i = chicken_idx; i < listChicken.size(); i++){
            if(vis[i] == true) continue;
            
            //탐색 전 포시
            vis[i] = true;
            listChosenChicken.add(new Pos(listChicken.get(i).x, listChicken.get(i).y));
            
            //탐색
            chooseChicken(i, depth + 1);
            
            //탐색 후 표시 제거
            vis[i] = false;
            listChosenChicken.remove(listChosenChicken.size()-1);
        }
    }
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        vis = new boolean[15];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1) listHouse.add(new Pos(i, j));
                else if(a == 2)listChicken.add(new Pos(i, j));
            }
        }
        
        chooseChicken(0, 0);
        System.out.println(res_distance);

	}
}