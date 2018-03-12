package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] dpArr = new long[N+1][2];
		long[] dp2Arr = new long[N+1];
		dpArr[1][1] = 1;
		
		// 规过 1
		for (int i = 2; i <= N; i++) {
			dpArr[i][0] = dpArr[i-1][0] + dpArr[i-1][1];
			dpArr[i][1] = dpArr[i-1][0];
		}
		
		System.out.println(dpArr[N][0] + dpArr[N][1]);
		
		// 规过 2
		dp2Arr[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp2Arr[i] = dp2Arr[i-1] + dp2Arr[i-2]; 
		}
		
		System.out.println(dp2Arr[N]);
	}

}
