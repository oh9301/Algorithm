package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2115 {
	
	static int answer;
	static int[][] map;
	static int[][] honeyValArr;
	static int N;
	static int M;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			divideBucket();
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	public static void divideBucket(){
		honeyValArr = new int[N][N-M+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				for (int ni = 0; ni < N; ni++) {
					for (int nj = 0; nj < N - M + 1; nj++) {
						if(i == ni && (nj > j - M && nj < j + M))
							continue;
						answer = Math.max(answer, getSum(i, j) + getSum(ni, nj));
					}
				}
			}
		}
	}
	
	public static int getSum(int i, int j){
		if(honeyValArr[i][j] != 0)
			return honeyValArr[i][j];
		int[] arr = new int[M];
		for (int k = 0; k < arr.length; k++)
			arr[k] = map[i][j+k];
		calcSum(0, arr, 0, 0, 0, i, j);
		return honeyValArr[i][j];
	}
	
	public static void calcSum(int index, int[] arr, int rest, int len, int sum, int x, int y){
		honeyValArr[x][y] = Math.max(sum, honeyValArr[x][y]);
		if(len == M){
			return;
		}
		for (int i = index; i < arr.length; i++) {
			if(rest + arr[i] <= C){
				calcSum(i + 1, arr, rest + arr[i], len + 1, sum + (arr[i] * arr[i]), x, y);
			}
		}
	}

}
