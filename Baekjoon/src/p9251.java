import java.util.Scanner;

/*
ACAYKP
CAPCAK
ACAYKP

4
*/
public class p9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] c1 = sc.next().toCharArray();
		char[] c2 = sc.next().toCharArray();
		int[][] dp = new int[c1.length][c2.length];
		
		for (int i = 0; i < c1.length; i++) {
			for (int j = 0; j < c2.length; j++) {
				if(j-1 >= 0 && i-1 >= 0){
					if(c1[i] == c2[j])
						dp[i][j] = dp[i-1][j-1] + 1 ;
					else
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
				else if(j-1 >= 0)
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : dp[i][j-1]);
				else if(i-1 >= 0)
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : dp[i-1][j]);
				else
					dp[i][j] = ((c1[i] == c2[j]) ? 1 : 0);
			}
		}
		
		System.out.println(dp[c1.length-1][c2.length-1]);
	}
}
