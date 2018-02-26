package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


//°æ»ç·Î
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