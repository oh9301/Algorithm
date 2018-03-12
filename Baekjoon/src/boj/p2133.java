package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2133 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[31];
		arr[2] = 3;
		arr[0] = 1;
		for (int i = 4; i <= N; i+=2) {
			// ÀÌÇØ°¨
			arr[i] = arr[i-2] * 3;
			for (int j = 4; j <= i; j++) {
				arr[i] += arr[i-j] * 2;
			} 
		}
		System.out.println(arr[N]);
	}

}
