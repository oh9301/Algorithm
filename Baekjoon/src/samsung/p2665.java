package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Maker{
	int i;
	int j;
	int count;
	
	public Maker(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}
	
}

public class p2665 {
	
	static final int INF = 10000;
	static int[][] map;
	static int[][] dp;
	static boolean[][] visited;
	static int answer, n;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String inp = br.readLine();
			for (int j = 0; j < n; j++)
				map[i][j] = inp.charAt(j) - '0';
			Arrays.fill(dp[i], INF);
		}
		visited[0][0] = true;
		answer = BFS();
		System.out.println(answer);
	}
	
	public static int BFS(){
		Queue<Maker> queue = new LinkedList<>();
		dp[0][0] = 0;
		queue.add(new Maker(0, 0, (map[0][0] == 1) ? 0 : 1));
		while(!queue.isEmpty()){
			Maker m = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ni = m.i + posi[k];
				int nj = m.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= n || nj >= n)
					continue;
				if(map[ni][nj] == 1){
					if(m.count < dp[ni][nj]){
						dp[ni][nj] = m.count;
						queue.add(new Maker(ni, nj, m.count));
					}
				}
				else{
					if(m.count + 1 < dp[ni][nj]){
						dp[ni][nj] = m.count + 1;
						queue.add(new Maker(ni, nj, m.count + 1));
					}
				}
			}
		}
		return dp[n-1][n-1];
	}

}
