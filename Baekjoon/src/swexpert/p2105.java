package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2105 {

	static int answer;
	static int[][] map;
	static int N;
	static int startX, startY, dirEnd;
	static int ptResult;
	static int[] posX = { 1, 1, -1, -1 };
	static int[] posY = { -1, 1, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = -1;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			calcMaxDessert();
			System.out.println("#" + (t + 1) + " " + answer);
		}
	}

	public static void calcMaxDessert() {
		boolean[] visit = new boolean[101];
		dirEnd = 3;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ptResult = -1;
				startX = i;	startY = j;
				searchDessertPath(0, i, j, 0, visit);
				answer = Math.max(ptResult, answer);
			}
		}
	}

	public static void searchDessertPath(int dir, int i, int j, int len, boolean[] visit) {
		if (dir == dirEnd && i == startX && j == startY) {
			ptResult = Math.max(ptResult, len);
			return;
		}
		if(dir >= dirEnd + 1)
			return;
		if(visit[map[i][j]])
			return;
		else
			visit[map[i][j]] = true;
		int ni = i + posX[dir];
		int nj = j + posY[dir];
		if (ni >= 0 && nj >= 0 && ni < N && nj < N)
			searchDessertPath(dir, ni, nj, len + 1, visit);
		if(dir < dirEnd){
			int ni2 = i + posX[dir+1];
			int nj2 = j + posY[dir+1];
			if (ni2 >= 0 && nj2 >= 0 && ni2 < N && nj2 < N)
				searchDessertPath(dir+1, ni2, nj2, len + 1, visit);
		}
		visit[map[i][j]] = false;
	}

}
