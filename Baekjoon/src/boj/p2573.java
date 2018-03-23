package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2573 {

	static int[][] map;
	static int answer, M, N;
	static boolean[][] visited;
	static int[] posI = { -1, 0, 1, 0 };
	static int[] posJ = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		int k = 0;
		while (true) {
			visited = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] != 0 && !visited[i][j]) {
						visited[i][j] = true;
						breakIce(i, j);
						count++;
					}
				}
			}
			if (count == 0) {
				answer = 0;
				break;
			} else if(count > 1){
				answer = k;
				break;
			}
			k++;
		}

		System.out.println(answer);

	}

	public static void breakIce(int i, int j) {
		for (int k = 0; k < 4; k++) {
			int ni = i + posI[k];
			int nj = j + posJ[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= M || visited[ni][nj])
				continue;
			if(map[ni][nj] == 0){
				if(map[i][j] > 0)
					map[i][j] -= 1;
			}else{
				visited[ni][nj] = true;
				breakIce(ni, nj);
			}
		}
	}

}
