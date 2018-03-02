package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14501 {
	
	static int answer;
	static int [][] arr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		calcAdFee(0, 0);
		System.out.println(answer);
	}
	
	public static void calcAdFee(int index, int sum){
		if(index == N){
			answer = (sum > answer) ? sum : answer;
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if(i + arr[i][0] <= N)
				calcAdFee(i + arr[i][0], sum + arr[i][1]);
			else
				answer = (sum > answer) ? sum : answer;
		}
	}

}
