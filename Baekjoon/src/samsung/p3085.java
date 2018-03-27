package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p3085 {

	static int N, answer = 1;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = inp.charAt(j);
		}

		bomboni();
		System.out.println(answer);
	}

	public static void bomboni() {
		char tmp = ' ';
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				tmp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tmp;
				search();
				tmp = map[i][j];
				map[i][j] = map[i][j + 1];
				map[i][j + 1] = tmp;
				
				tmp = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = tmp;
				search();
				tmp = map[j][i];
				map[j][i] = map[j + 1][i];
				map[j + 1][i] = tmp;
			}
		}
	}

	public static void search() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				xcalc(map[i][j], i, j);
				ycalc(map[i][j], i, j);
			}
		}
	}

	public static void xcalc(char c, int i, int j) {
		int nj = j;
		for (int k = 1; k <= N; k++) {
			nj += 1;
			if (nj >= N || map[i][nj] != c) {
				answer = Math.max(k, answer);
				return;
			}
		}
	}

	public static void ycalc(char c, int i, int j) {
		int ni = i;
		for (int k = 1; k <= N; k++) {
			ni += 1;
			if (ni >= N || map[ni][j] != c) {
				answer = Math.max(k, answer);
				return;
			}
		}
	}
}
