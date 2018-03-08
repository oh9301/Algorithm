package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//2000MS 비효율적..
public class p2105 {

	static int answer;
	static int[][] map;
	static int N;
	static int startX;
	static int startY;
	static int ptResult;
	static int[] posX = { -1, 1, -1, 1 };
	static int[] posY = { 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}

			calcMaxDessert();
			if (answer == 0)
				answer = -1;
			System.out.println("#" + (t + 1) + " " + answer);
		}
	}

	public static void calcMaxDessert() {
		Set<Integer> vSet;
		Set<Integer> dirSet;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				vSet = new HashSet<>();
				dirSet = new HashSet<>();
				ptResult = 0;
				startX = i;
				startY = j;
				searchDessertPath(i, j, vSet, dirSet, 0, 0);
				answer = Math.max(ptResult, answer);
			}
		}
	}

	public static void searchDessertPath(int i, int j, Set visit, Set dirSet, int len, int prevDis) {
		visit.add(map[i][j]);
		if (len != 0 && i == startX && j == startY) {
			if (dirSet.size() == 4) {
				ptResult = Math.max(ptResult, len);
				return;
			}
			return;
		}
		for (int k = 1; k <= 4; k++) {
			int ni = i + posX[k - 1];
			int nj = j + posY[k - 1];
			if (ni >= 0 && nj >= 0 && ni < N && nj < N) {
				if (!visit.contains(map[ni][nj]) || (ni == startX && nj == startY)) {
					if (!dirSet.contains(k)) {
						dirSet.add(k);
						searchDessertPath(ni, nj, visit, dirSet, len + 1, k);
						dirSet.remove(k);
					} else if (prevDis == k)
						searchDessertPath(ni, nj, visit, dirSet, len + 1, k);
				}
			}
		}
		visit.remove(map[i][j]);
	}

}
