package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
n���� ������ ������ �ִ�. ������ ������ ��Ÿ���� ��ġ�� �ٸ���.
�� �������� ������ ����ؼ�, �� ��ġ�� ���� k���� �ǵ��� �ϰ� �ʹ�. 
�׷��鼭 ������ ������ �ּҰ� �ǵ��� �Ϸ��� �Ѵ�. (������ ������ ��� ����� �� �ִ�.)

ù°�ٿ� n, k�� �־�����. (1 �� n �� 100, 1 �� k �� 10,000) ���� n���� �ٿ��� ������ ������ ��ġ�� �־�����.

ù°�ٿ� ����� ������ �ּ� ������ ����Ѵ�. �Ұ����� ��쿡�� -1�� ����Ѵ�.

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
