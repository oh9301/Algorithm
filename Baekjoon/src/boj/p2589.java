package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pt{
	int i;
	int j;
	
	public Pt(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
}

public class p2589 {
	
	static int M, N, answer;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = str.charAt(j);
				if(c == 'W')
					map[i][j] = -1;
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > -1){
					searchTreasure(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static void searchTreasure(int i, int j){
		int distance = -1;
		visited = new boolean[M][N];
		Queue<Pt> cQueue = new LinkedList<>();
		Queue<Pt> nextQueue = new LinkedList<>();
		cQueue.add(new Pt(i, j));
		visited[i][j] = true;
		
		while(!cQueue.isEmpty()){
			for (Pt p : cQueue) {
				if(p.i - 1 >= 0 && map[p.i - 1][p.j] == 0 && !visited[p.i - 1][p.j]){
					nextQueue.add(new Pt(p.i - 1, p.j));
					visited[p.i - 1][p.j] = true;
				}
				if(p.i + 1 < M && map[p.i + 1][p.j] == 0 && !visited[p.i + 1][p.j]){
					nextQueue.add(new Pt(p.i + 1, p.j));
					visited[p.i + 1][p.j] = true;
				}
				if(p.j - 1 >= 0 && map[p.i][p.j - 1] == 0 && !visited[p.i][p.j - 1]){
					nextQueue.add(new Pt(p.i, p.j - 1));
					visited[p.i][p.j - 1] = true;
				}
				if(p.j + 1 < N && map[p.i][p.j + 1] == 0 && !visited[p.i][p.j + 1]){
					nextQueue.add(new Pt(p.i, p.j + 1));
					visited[p.i][p.j + 1] = true;
				}
			}
			cQueue.clear();
			cQueue.addAll(nextQueue);
			nextQueue.clear();
			distance++;
		}
		
		answer = Math.max(answer, distance);
	}

}
