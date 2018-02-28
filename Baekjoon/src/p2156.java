import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
포도주 잔을 선택하면 그 잔에 들어있는 포도주는 모두 마셔야 하고, 마신 후에는 원래 위치에 다시 놓아야 한다.
연속으로 놓여 있는 3잔을 모두 마실 수는 없다.

7
8
8
2
5
9
7
1

32
*/
public class p2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N + 2];
		int[][] dp = new int[2][N + 2];
		int max = 0;
		int rowMax = 0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		dp[0][0] = score[0];
		dp[0][1] = score[0] + score[1];
		if (score[1] == 0)
			dp[1][1] = dp[0][1];
		else
			dp[1][1] = score[1];

		for (int i = 2; i < N; i++) {
			dp[0][i] = Math.max(dp[1][i - 1] + score[i], dp[0][i - 1]);
			dp[1][i] = Math.max(Math.max(Math.max(dp[0][i - 2] + score[i], dp[1][i - 2] + score[i]), dp[0][i - 1]), dp[1][i - 1]);
		}
		for (int i = 1; i <= N; i++) {
			rowMax = Math.max(dp[0][i - 1], dp[1][i - 1]);
			max = (max < rowMax) ? rowMax : max;
		}
		System.out.println(max);
	}

}
