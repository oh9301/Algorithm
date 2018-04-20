package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11727 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N+1];
		arr1[1] = 1;
		if(N != 1){
			arr1[2] = 3;
			for (int i = 3; i <= N; i++) {
				arr1[i] = (arr1[i-1] + arr1[i-2]*2)%10007;
			}
		}
		System.out.println(arr1[N]);
	}

}
