package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class SL{
	int i;
	int j;
	
	public SL(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
}

public class p15684 {
	
	static int answer;
	static int N, M, H;
	static int[][] map;
	static int[] posi = {0, 0, 1};
	static int[] posj = {1, -1, 0};
	static ArrayList<SL> slist;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H+2][N*2-1];
		answer = -1;
		slist = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b*2-1] = 1;
		}
		for (int i = 1; i <= H+1; i++) {
			for (int j = 0; j < N*2-1; j+=2) {
				map[i][j] = 1;
			}
		}
		for (int i = 1; i < H+1; i++) {
			for (int j = 1; j < N*2-1; j+=2) {
				if(map[i][j] == 0){
					slist.add(new SL(i, j));
				}
			}
		}
		
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map[i].length; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for (int k = 0; k <= 3; k++) {
			dfs(0, 0, k);
			if(answer != -1)
				break;
		}
		System.out.println(answer);
	}
	
	public static void dfs(int index, int len, int goal){
		if(len == goal){
			if(movePerson())
				answer = goal;
			return;
		}
		if(answer == -1){
			for (int i = index; i < slist.size(); i++) {
				SL s = slist.get(i);
				if(s.j+2 < N*2-1 && map[s.i][s.j+2] == 1)
					continue;
				if(s.j-2 >= 0 && map[s.i][s.j-2] == 1)
					continue;
				map[s.i][s.j] = 1;
				dfs(i+1, len+1, goal);
				map[s.i][s.j] = 0;
			}
		}
	}
	
	public static boolean movePerson(){
		for (int index = 0; index < N*2-1; index+=2) {
			int i = 0;
			int j = index;
			int dir = 2;
			while(i != H+1){
				for (int d = 0; d < 3; d++) {
					int ni = i + posi[d];
					int nj = j + posj[d];
					if(ni < 0 || nj < 0 || nj >= N*2-1 || map[ni][nj] == 0)
						continue;
					if((d == 1 && dir == 0) || (d == 0 && dir == 1))
						continue;
					dir = d;
					i = ni;
					j = nj;
					break;
				}
			}
			if(j != index)
				return false;
		}
		return true;
	}

}
