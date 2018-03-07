package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pt{
	int x;
	int y;
	
	public Pt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class p1949 {
	
	static int answer;
	static int[][] map;
	static int[][] tmpMap;
	static int N;
	static int K;
	static int[] posX = {-1, 1, 0, 0};
	static int[] posY = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			execKRemove();
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	public static ArrayList<Pt> getHighestPoint(){
		ArrayList<Pt> arlist = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				max = (max < map[i][j]) ? map[i][j] : max;
				
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++){
				if(max == map[i][j])
					arlist.add(new Pt(i, j));
			}
		
		return arlist;
	}
	
	public static void execKRemove(){
		for (int i = 0; i <= K; i++) {
			if(i == 0){
				for(Pt p : getHighestPoint())
					answer = Math.max(answer, calcHikingPathDFS(p.x, p.y) + 1);
			} else{
				for (int kx = 0; kx < N; kx++){
					for (int ky = 0; ky < N; ky++){ 
						for(Pt p : getHighestPoint()){
							map[kx][ky] -= i;
							answer = Math.max(answer, calcHikingPathDFS(p.x, p.y) + 1);
							map[kx][ky] += i;
						}
					}
				}
			}
		}
	}
	
	public static int calcHikingPathDFS(int i, int j){
		int sum = 0;
		for (int l = 0; l < 4; l++) {
			int nX = i + posX[l];
			int nY = j + posY[l];
			if(nX >= N || nY >= N || nX < 0 || nY < 0 || map[nX][nY] >= map[i][j])
				continue;
			sum = Math.max(sum, calcHikingPathDFS(nX, nY) + 1);
		}
		return sum;
	}

}
