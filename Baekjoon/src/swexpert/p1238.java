package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Person{
	int val;
	int count;
	
	public Person(int val, int count) {
		this.val = val;
		this.count = count;
	}
}

public class p1238 {
	
	static int answer, anc;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = 0;
			anc = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			map = new boolean[101][101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				map[u][v] = true;
			}
			bfs(start);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void bfs(int start){
		boolean[] visited = new boolean[101];
		Queue<Person> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(new Person(start, 0));
		while(!queue.isEmpty()){
			Person p = queue.poll();
			if(anc != p.count){
				answer = p.val;
				anc++;
			}else
				answer = Math.max(answer, p.val);
			for (int i = 1; i <= 100; i++) {
				if(map[p.val][i] && !visited[i]){
					visited[i] = true;
					queue.add(new Person(i, p.count + 1));
				}
			}
		}
	}
}