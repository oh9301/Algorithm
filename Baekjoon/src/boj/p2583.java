package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2583 {
	
	static int answer;
	static int M, N, K;
	static int[][] kArr;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ansList = new ArrayList<>();
		kArr = new int[K][];
		map = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			kArr[i] = new int[4];
			for (int j = 0; j < 4; j++)
				kArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		fillRec();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(!map[i][j]){
					map[i][j] = true;
					answer++;
					ansList.add(getWidthSum(i, j));
				}
			}
		}
		
		System.out.println(answer);
		Collections.sort(ansList);
		for (int elem : ansList)
			System.out.print(elem + " ");
	}

	public static void fillRec(){
		for (int i = 0; i < K; i++) {
			for (int j = M - kArr[i][3]; j < M - kArr[i][1]; j++) {
				for (int k = kArr[i][0]; k < kArr[i][2]; k++) {
					map[j][k] = true;
				}
			}
		}
	}
	
	public static int getWidthSum(int i, int j){
		int sum = 1;
		if(i+1 < M && !map[i+1][j]){
			map[i+1][j] = true;
			sum += getWidthSum(i+1, j);
		}
		if(i-1 >= 0 && !map[i-1][j]){
			map[i-1][j] = true;
			sum += getWidthSum(i-1, j);
		}
		if(j+1 < N && !map[i][j+1]){
			map[i][j+1] = true;
			sum += getWidthSum(i, j+1);
		}
		if(j-1 >= 0 && !map[i][j-1]){
			map[i][j-1] = true;
			sum += getWidthSum(i, j-1);
		}
		return sum;
	}
}
