package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2638 {
	
	static int N, M, answer;
	static int[][] map;
	static int[][] visited;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = st.nextToken().charAt(0) - '0';
		}
		while(true){
			int count = 0;
			visited = new int[N][M];
			visited[0][0] = -1;
			divExternalAir(0, 0);
			
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
					if(visited[i][j] == 0 && map[i][j] == 1){
						visited[i][j] = 1;
						melting(i, j);
						count++;
					}
				}
			}
			if(count == 0)
				break;
			answer++;
		}
		System.out.println(answer);
	}
	
	public static void divExternalAir(int i, int j){
		for (int k = 0; k < 4; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= M || visited[ni][nj] < 0 || map[ni][nj] == 1)
				continue;
			visited[ni][nj] = -1;
			divExternalAir(ni, nj);
		}
	}
	
	public static void melting(int i, int j){
		int cnt = 0;
		for (int k = 0; k < 4; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= M || visited[ni][nj] == 1)
				continue;
			if(map[ni][nj] == 0 && visited[ni][nj] < 0)
				cnt++;
			if(map[ni][nj] == 1){
				visited[ni][nj] = 1;
				melting(ni, nj);
			}
		}
		if(cnt >= 2)
			map[i][j] = 0;
	}
}
/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 0 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 0 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
*/