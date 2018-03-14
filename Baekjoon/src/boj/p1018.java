package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1018 {
	
	static int answer;
	static int[][] blackArr;
	static int[][] whiteArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		blackArr = new int[N][M];
		whiteArr = new int[N][M];
		answer = 64;
		
		for (int i = 0; i < N; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if((i+j)%2 == 0){
					blackArr[i][j] = (line[j].equals("B")) ? 0 : 1;
					whiteArr[i][j] = (line[j].equals("B")) ? 1 : 0;
				} else{
					blackArr[i][j] = (line[j].equals("W")) ? 0 : 1;
					whiteArr[i][j] = (line[j].equals("W")) ? 1 : 0;
				}
			}
		}
		
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				answer = Math.min(answer, calcPartSum(i, j));
			}
		}
		
		System.out.println(answer);
	}
	
	public static int calcPartSum(int stI, int stJ){
		int sumBlack = 0;
		int sumWhite = 0;
		for (int i = stI; i < stI + 8; i++) {
			for (int j = stJ; j < stJ + 8; j++) {
				sumBlack += blackArr[i][j];
				sumWhite += whiteArr[i][j];
			}
		}
		return Math.min(sumBlack, sumWhite);
	}

}
