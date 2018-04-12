package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Fork implements Comparable<Fork>{
	int i;
	int j;
	int count;
	
	public Fork(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}

	@Override
	public int compareTo(Fork o) {
		return this.count - o.count;
	}
	
	
	
}

public class p1249 {
	
	static int N, answer;
	static int[][] map;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String inp = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = inp.charAt(j) - '0';
			}
			
			BFS();
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void BFS(){
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		PriorityQueue<Fork> queue = new PriorityQueue<>();
		queue.add(new Fork(0, 0, 0));
		while(!queue.isEmpty()){
			Fork fp = queue.poll();
			if(fp.i == N-1 && fp.j == N-1){
				answer = fp.count;
				return;
			}
			for (int k = 0; k < 4; k++) {
				int ni = fp.i + posi[k];
				int nj = fp.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= N || nj >= N)
					continue;
				if(dp[ni][nj] > fp.count + map[ni][nj]){
					dp[ni][nj] = fp.count + map[ni][nj];
					queue.add(new Fork(ni, nj, dp[ni][nj]));
				}
			}
		}
	}

}
