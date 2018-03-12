package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p2780 {

	static int[][] path;
	static int[][] memo;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[] dirX = { 1, -1, 0, 0 };
		int[] dirY = { 0, 0, 1, -1 };
		int[][] pwd = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 0, -1, -1 } };
		path = new int[10][10];
		memo = new int[1001][10];
		for (int i = 0; i < 10; i++)
			memo[1][i] = 1;
		for (int i = 0; i < pwd.length; i++)
			for (int j = 0; j < pwd[i].length; j++) {
				if (pwd[i][j] == -1)
					continue;
				for (int k = 0; k < 4; k++) {
					int nX = j + dirX[k];
					int nY = i + dirY[k];
					if (nX >= 0 && nY >= 0 && nX < 3 && nY < 4 && pwd[nY][nX] != -1) {
						path[pwd[nY][nX]][pwd[i][j]] = 1;
						path[pwd[i][j]][pwd[nY][nX]] = 1;
					}
				}
			}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			if (N >= 2) {
				for (int i = 2; i <= N; i++)
					calcMemo(i);
			}
			answer = 0;
			for (int i = 0; i < 10; i++) {
				answer = (answer + memo[N][i]) % 1234567;
			}
			System.out.println(answer);
		}
	}

	public static void calcMemo(int N) {
		for (int i = 0; i < path.length; i++) {
			if (memo[N][i] != 0)
				continue;
			for (int j = 0; j < path.length; j++) {
				if (path[i][j] == 1) {
					memo[N][i] = (memo[N][i] + memo[N - 1][j]) % 1234567;
				}
			}
		}
	}

}
