package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point2{
	int r;
	int c;
	public Point2(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class p1953 {
	
	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] pathArr;
	static boolean[][] goArr;
	static int[] posX = {-1, 0, 1, 0};
	static int[] posY = {0, -1, 0, 1};
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		initConfig();
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			calcCase();
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	public static void calcCase(){
		ArrayList<Point2> qList = new ArrayList<>();
		ArrayList<Point2> nList = new ArrayList<>();
		boolean[][] visit = new boolean[N][M];
		qList.add(new Point2(R, C));
		while(!qList.isEmpty() && L > 0){
			for (Point2 p : qList){
				if(visit[p.r][p.c])
					continue;
				visit[p.r][p.c] = true;
				for (int i = 0; i < 4; i++) {
					if(goArr[map[p.r][p.c]][i]){
						int nr = p.r + posX[i];
						int nc = p.c + posY[i];
						if(nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || !pathArr[i][map[nr][nc]])
							continue;
						nList.add(new Point2(nr, nc));
					}
				}
				answer++;
			}
			qList.clear();
			qList.addAll(nList);
			nList.clear();
			L--;
		}
	}
	
	public static void initConfig(){
		goArr = new boolean[8][4];
		goArr[1][0] = true;	goArr[1][1] = true; goArr[1][2] = true;	goArr[1][3] = true;
		goArr[2][0] = true;	goArr[2][2] = true;
		goArr[3][1] = true;	goArr[3][3] = true;
		goArr[4][0] = true;	goArr[4][3] = true;
		goArr[5][2] = true;	goArr[5][3] = true;
		goArr[6][1] = true;	goArr[6][2] = true;
		goArr[7][0] = true;	goArr[7][1] = true;
		pathArr = new boolean[4][8];
		pathArr[0][1] = true; pathArr[0][2] = true; pathArr[0][5] = true; pathArr[0][6] = true;
		pathArr[1][1] = true; pathArr[1][3] = true; pathArr[1][4] = true; pathArr[1][5] = true;
		pathArr[2][1] = true; pathArr[2][2] = true; pathArr[2][4] = true; pathArr[2][7] = true;
		pathArr[3][1] = true; pathArr[3][3] = true; pathArr[3][6] = true; pathArr[3][7] = true;
	}

}
