package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1486 {
	
	static int N, B, answer;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 200001;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			dfs(0, 0);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void dfs(int index, int size){
		if(size >= B){
			answer = Math.min(size - B, answer);
			return;
		}
		for (int i = index; i < N; i++) 
			dfs(i+1, size + arr[i]);
	}

}
