package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
길을 지나갈 수 있으려면 길에 속한 모든 칸의 높이가 모두 같아야 한다. 또는, 경사로를 놓아서 지나갈 수 있는 길을 만들 수 있다.
경사로는 높이가 항상 1이며, 길이는 L이다. 또, 개수는 매우 많아 부족할 일이 없다. 경사로는 낮은 칸과 높은 칸을 연결하며, 아래와 같은 조건을 만족해야한다.

경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.

아래와 같은 경우에는 경사로를 놓을 수 없다.

경사로를 놓은 곳에 또 경사로를 놓는 경우
낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
경사로를 놓다가 범위를 벗어나는 경우

지도가 주어졌을 때, 지나갈 수 있는 길의 개수를 구하는 프로그램을 작성하시오.

6 1
3 2 1 1 2 3
3 2 2 1 2 3
3 2 2 2 3 3
3 3 3 3 3 3
3 3 3 3 2 2
3 3 3 3 2 2

11
*/
//경사로
public class p14890 {

	static int answer;
	static int N;
	static int L;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int[][] path = new int[N*2][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				path[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) 
					path[i+N][j] = path[j][i];
		}
		for (int i = 0; i < path.length; i++) {
			answer += calcPath(path[i]);
		}
		

		System.out.println(answer);
	}
	
	public static int calcPath(int[] onePath){
		int[] visit = new int[N];
		int preVal = onePath[0];
		for (int i = 1; i < N; i++) {
			if(Math.abs(onePath[i] - preVal) > 1)
				return 0;
			if(onePath[i] > preVal){
				for (int j = i-L; j <= i-1; j++) {
					if(j < 0 || visit[j] == 1)
						return 0;
					visit[j] = 1;
				}
			} else if(onePath[i] < preVal){
				for (int j = i; j < i+L; j++) {
					if(j >= N || visit[j] == 1)
						return 0;
					visit[j] = 1;
				}
			}
			
			preVal = onePath[i];
		}
		return 1;
	}
}