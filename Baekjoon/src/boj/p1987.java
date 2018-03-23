package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1987 {
	
	static int answer, R, C;
	static int[][] map;
	static boolean[] visited;
	static int[] posI = {-1, 0, 1, 0};
	static int[] posJ = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[26];
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++)
				map[i][j] = str.charAt(j) - 'A';
		}
		
		visited[map[0][0]] = true;
		dfs(1, 0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int cnt, int i, int j){
		visited[map[i][j]] = true;
		if(i + 1 < R && !visited[map[i+1][j]])
			dfs(cnt + 1, i+1, j);
		if(j + 1 < C && !visited[map[i][j+1]])
			dfs(cnt + 1, i, j+1);
		if(i - 1 >= 0 && !visited[map[i-1][j]])
			dfs(cnt + 1, i-1, j);
		if(j - 1 >= 0 && !visited[map[i][j-1]])
			dfs(cnt + 1, i, j-1);
		visited[map[i][j]] = false;
		answer = (answer < cnt) ? cnt : answer;
	}

}
