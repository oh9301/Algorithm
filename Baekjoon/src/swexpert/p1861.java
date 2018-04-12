package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1861 {
	
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int num = 1000001;
			int answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(answer < search(i, j) + 1){
						num = map[i][j];
						answer = search(i, j) + 1;
					} else if(answer == search(i, j) + 1)
						num = Math.min(num, map[i][j]);
				}
			}
			System.out.println("#"+t+" "+num + " " + answer);
		}
	}
	
	public static int search(int i, int j){
		if(dp[i][j] != 0)
			return dp[i][j];
		for (int k = 0; k < 4; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= N)
				continue;
			if(map[ni][nj] - map[i][j] == 1){
				dp[i][j] = Math.max(dp[i][j], search(ni, nj) + 1);
			}
		}
		
		return dp[i][j];
	}

}
