package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다.
이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
그러면서 동전의 개수가 최소가 되도록 하려고 한다. (각각의 동전은 몇개라도 사용할 수 있다.)

첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.

첫째줄에 사용한 동전의 최소 개수를 출력한다. 불가능한 경우에는 -1을 출력한다.

3 15
1
5
12

3
*/
public class p2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] valArr = new int[n];
		int[] dp = new int[k+1];
		for (int i = 0; i < n; i++) {
			valArr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(valArr);
		dp[0] = 1;
		for (int i = valArr[0] ; i <= k ; i++) {
			for(int val : valArr){
				if(i - val < 0)
					continue;
				if(dp[i-val] != 0){
					if(dp[i] != 0)
						dp[i] = ((i-val) == 0) ? 1 : (dp[i] > dp[i-val] + dp[val]) ? dp[i-val] + dp[val] : dp[i];
					else
						dp[i] = ((i-val) == 0) ? 1 : dp[i-val] + dp[val];
					
				}
			}
		}
		if(dp[k] == 0){
			System.out.println(-1);
			return;
		}
		System.out.println(dp[k]);
	}

}
