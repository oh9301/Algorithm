import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2240 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] dp = new int[T][W + 1];
		int[] fArr = new int[T];
		for (int i = 0; i < T; i++) {
			fArr[i] = Integer.parseInt(br.readLine());
		}
		if(fArr[0] == 1)
			dp[0][0] = 1;
		else
			dp[0][1] = 1;

		for (int i = 1; i < T; i++) {
			dp[i][0] = (fArr[i] == 1) ? dp[i - 1][0] + 1 : dp[i - 1][0];
			if (fArr[i] == 1) {
				for (int j = 1; j <= W; j++) {
					dp[i][j] = (j % 2 == 0) ? Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1
							: Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			} else{
				for (int j = 1; j <= W; j++) {
					dp[i][j] = (j % 2 == 0) ? Math.max(dp[i - 1][j], dp[i - 1][j - 1])
							: Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
				}
			}
		}
		int max = 0;
		for (int i = 0; i <= W; i++) {
			max = (dp[T-1][i] > max) ? dp[T-1][i] : max;
		}
		System.out.println(max);
	}

}
