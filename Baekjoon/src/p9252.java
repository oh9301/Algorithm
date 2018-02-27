import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ACAYKP
CAPCAK
ACAYKP

4
*/

public class p9252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c1 = br.readLine().toCharArray();
		char[] c2 = br.readLine().toCharArray();
		int[][] dp = new int[c1.length][c2.length];
		char[] word;

		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if (j - 1 >= 0 && i - 1 >= 0) {
					if (c1[i] == c2[j])
						dp[i][j] = dp[i - 1][j - 1] + 1;
					else
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				} else if (j - 1 >= 0)
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : dp[i][j - 1]);
				else if (i - 1 >= 0)
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : dp[i - 1][j]);
				else
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : 0);
			}
		}

		word = new char[dp[c1.length - 1][c2.length - 1]];
		int wIndex = word.length - 1;
		int row = c1.length - 1;
		int col = c2.length - 1;
		while (wIndex >= 0) {
			if (c1[row] == c2[col]) {
				word[wIndex] = c1[row];
				wIndex--;
				if (row > 0 && col > 0) {
					row--;
					col--;
					continue;
				}
				break;
			}
			if (row > 0 && dp[row][col] == dp[row - 1][col])
				row--;
			else if (col > 0 && dp[row][col] == dp[row][col - 1])
				col--;
		}
		System.out.println(dp[c1.length - 1][c2.length - 1]);
		System.out.println(new String(word));
		br.close();
	}

}
