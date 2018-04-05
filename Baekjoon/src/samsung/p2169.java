package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2169 {
	
	static int[][] map;
	static int[][][] dp;
	static int N, M, answer;
	static int[] posi = {0, 0, 1};
	static int[] posj = {1, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dp = new int[N][M][3];
			
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer = calcMaxSum();
		System.out.println(answer);
	}
	
	public static int calcMaxSum(){
		//init
		for (int i = 0; i < N; i++) {
			if(i == 0){
				dp[0][0][0] = dp[0][0][1] = dp[0][0][2] = map[0][0];
				for (int j = 1; j < M; j++)
					dp[i][j][0] = map[i][j] + dp[i][j-1][0];
			} else if(i < N - 1){
				dp[i][0][1] = dp[i-1][0][0] + map[i][0];
				dp[i][M-1][2] = dp[i-1][M-1][0] + map[i][M-1];
				for (int j = 1; j < M; j++)
					dp[i][j][1] = Math.max(dp[i][j-1][1], dp[i-1][j][0]) + map[i][j];
				for (int j = M-2; j >= 0; j--)
					dp[i][j][2] = Math.max(dp[i][j+1][2], dp[i-1][j][0]) + map[i][j];
				for (int j = 0; j < M; j++)
					dp[i][j][0] = Math.max(dp[i][j][1], dp[i][j][2]);
			} else{
				dp[i][0][0] = dp[i-1][0][0] + map[i][0]; 
				for (int j = 1; j < M; j++)
					dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i-1][j][0]) + map[i][j];
			}
		}
		
		return dp[N-1][M-1][0];
	}
	/*
	public static int DFS(int i, int j){
		if(i == N-1 && j == M-1)
			return map[i][j];
		if(dp[i][j][0] != INF)
			return dp[i][j][0];
		for (int k = 0; k < 3; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= M || visited[ni][nj])
				continue;
			visited[ni][nj] = true;
			dp[i][j][0] = Math.max(dp[i][j][0], map[i][j] + DFS(ni, nj));
			visited[ni][nj] = false;
		}
		return dp[i][j][0];
	}
	*/
}
