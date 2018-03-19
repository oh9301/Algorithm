package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12100 {
	
	static int answer;
	static int N;
	static int[] dirX = {-1, 0, 1, 0};
	static int[] dirY = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] smap = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				smap[i][j] = Integer.parseInt(st.nextToken());
		}
		leanBoard(0, smap);
		System.out.println(answer);
	}
	
	public static int[][] copyMap(int[][] map){
		int[][] cpMap = new int[N][];
		for (int i = 0; i < map.length; i++)
			cpMap[i] = map[i].clone();
		return cpMap;
	}
	
	public static int getMaxVal(int[][] map){
		int max = 0;
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map.length; j++)
				max = (map[i][j] > max) ? map[i][j] : max;
		return max;
	}
	
	public static void printMap(int[][] map){
		for (int i = 0; i < map.length; i++){
			for (int j = 0; j < map.length; j++){
				System.out.print(map[i][j]+ " ");
			}System.out.println();
		}
		System.out.println();
	}
	
	public static void leanBoard(int count, int[][] map){
		int [][] nMap;
		if(count > 5)
			return;
		answer = Math.max(answer, getMaxVal(map));
		for (int i = 0; i < 4; i++) {
			nMap = execAllMove(i, copyMap(map));
			leanBoard(count + 1, nMap);
		}
	}

	public static int[][] execAllMove(int dir, int[][] map){
		boolean[][] visit = new boolean[N][N];
		if(dir == 0){
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map.length; j++) 
					move(map, i, j, dir, visit);
		} else if(dir == 1){
			for (int i = 0; i < map.length; i++)
				for (int j = 0; j < map.length; j++) 
					move(map, i, j, dir, visit);
		} else if(dir == 2){
			for (int i = map.length - 1; i >= 0; i--)
				for (int j = 0; j < map.length; j++) 
					move(map, i, j, dir, visit);
		} else{
			for (int i = 0; i < map.length; i++)
				for (int j = map.length - 1; j >= 0; j--) 
					move(map, i, j, dir, visit);
		}
		return map;
	}
	
	public static void move(int[][] map, int i, int j, int df, boolean[][] visit){
		int ni = 0, nj = 0;
		if(map[i][j] == 0 || visit[i][j])
			return;
		for (int k = 0; k < N; k++) {
			ni = i + dirX[df];
			nj = j + dirY[df];
			if(ni < 0 || nj < 0 || ni >= N || nj >= N)
				return;
			if(visit[ni][nj])
				return;
			else if(map[ni][nj] == 0){
				map[ni][nj] = map[i][j];
				map[i][j] = 0;
			} else if(map[ni][nj] != map[i][j])
				return;
			else if(map[ni][nj] == map[i][j] && !visit[ni][nj]){
				map[ni][nj] += map[i][j];
				visit[ni][nj] = true;
				map[i][j] = 0;
				return;
			} 
			i = ni;
			j = nj;
		}
	}
}
