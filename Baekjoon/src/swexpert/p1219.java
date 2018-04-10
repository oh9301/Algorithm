package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1219 {
	
	static int[][] map;
	static int L, answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			map = new int[100][100];
			for (int i = 0; i < L; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[u][v] = 1;
			}
			
			BFS(0);
			answer = (visited[99] == true) ? 1 : 0;
			System.out.println("#"+T+" "+answer);
		}
	}
	
	public static void BFS(int start){
		visited = new boolean[100];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()){
			int elem = queue.poll();
			for (int i = 0; i < 100; i++) {
				if(elem == i)
					continue;
				if(map[elem][i] == 1 && !visited[i]){
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
