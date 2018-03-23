package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class p11403 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited;
		for (int i = 0; i < N; i++) {
			visited = new boolean[N]; 
			calcPathDFS(i, i, visited);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static void calcPathDFS(int st, int i, boolean[] visited){
		for (int j = 0; j < N; j++) {
			if(map[i][j] == 1 && !visited[j]){
				map[st][j] = 1;
				visited[j] = true;
				calcPathDFS(st, j, visited);
			}
		}
	}
}
