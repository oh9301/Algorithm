package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p11399 {
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mVal = 0;
		int[] tArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tArr);
		for (int i = 0; i < tArr.length; i++) {
			//mVal += tArr[i];
			//answer += mVal;
			answer += tArr[i] * (N - i);
		}
		System.out.println(answer);
	}

}
