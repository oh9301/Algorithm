import java.util.Scanner;

public class p1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				dp[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		result = Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		System.out.println(result);
	}

}
