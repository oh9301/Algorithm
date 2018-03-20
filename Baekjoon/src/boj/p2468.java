package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2468 {

	static int answer;
	static int N;
	static int[][] nArr;
	static boolean[][] visit;
	static int[] posX = {1, 0, -1, 0};
	static int[] posY = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nArr = new int[N][N];
		int maxVal = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++){
				nArr[i][j] = Integer.parseInt(st.nextToken());
				maxVal = (nArr[i][j] > maxVal) ? nArr[i][j] : maxVal;
			}
		}
		
		for (int r = 0; r < maxVal; r++) {
			int midAns = 0;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j] && nArr[i][j] > r){
						searchSafetyArea(i, j, r);
						midAns++;
					}
				}
			}
			answer = Math.max(midAns, answer);
		}
		System.out.println(answer);
	}
	
	public static void searchSafetyArea(int i, int j, int range){
		for (int k = 0; k < 4; k++) {
			int ni = i + posX[k];
			int nj = j + posY[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= N || visit[ni][nj] || nArr[ni][nj] <= range)
				continue;
			visit[ni][nj] = true;
			searchSafetyArea(ni, nj, range);
		}
	}

}
