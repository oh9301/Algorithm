package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2563_2 {
	
	static int answer;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[100][100];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dfs(x+10, y+10, x, y);
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int ri, int rj, int i, int j){
		if(!visited[i][j])
			answer++;
		visited[i][j] = true;
		if(i+1 < ri)
			dfs(ri, rj, i+1, j);
		if(j+1 < rj)
			dfs(ri, rj, i, j+1);
	}

}
