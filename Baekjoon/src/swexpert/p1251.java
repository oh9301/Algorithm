package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1251 {
	
	static int N;
	static double E;
	static long answer;
	static long[][] xyArr;
	static long[][] dMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			xyArr = new long[N][2];
			dMap = new long[N][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					xyArr[j][i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					long dist = (xyArr[j][0] - xyArr[i][0]) * (xyArr[j][0] - xyArr[i][0]) + (xyArr[j][1] - xyArr[i][1]) * (xyArr[j][1] - xyArr[i][1]);
					dMap[i][j] = dist;
					dMap[j][i] = dist;
				}
			}
			for(long res : search()){
				answer += res;
			}
			System.out.println("#"+t+" " + Math.round(E * answer));
		}
	}
	
	public static long[] search(){
		long[] dist = new long[N];
		Arrays.fill(dist, Long.MAX_VALUE);
		boolean[] visited = new boolean[N];
		dist[0] = 0;
		for (int i = 0; i < N; i++) {
			int minIndex = -1;
			long minV = Long.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if(!visited[j] && dist[j] < minV){
					minIndex = j;
					minV = dist[j];
				}
			}
			if(minIndex == -1)
				return dist;
			visited[minIndex] = true;
			for(int k = 0 ; k < N ; k++){
				if(!visited[k]){
					if(dist[k] > dMap[minIndex][k]){
						dist[k] = dMap[minIndex][k];
					}
				}
			}
		}
		return dist;
	}
}
