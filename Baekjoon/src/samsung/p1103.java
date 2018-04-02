package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coin{
	int x;
	int y;
	int count;
	public Coin(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
	
}

public class p1103 {
	
	static int N, M, answer;
	static int[][] map;
	static int[][] visited;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < M; j++) {
				char c = inp.charAt(j);
				if(c == 'H')
					map[i][j] = 0;
				else
					map[i][j] = c - '0';
			}
		}
		visited = new int[N][M];
		BFS();
		System.out.println(answer);
	}
	
	public static void BFS(){
		Queue<Coin> queue = new LinkedList<>();
		queue.add(new Coin(0, 0, 1));
		while(!queue.isEmpty()){
			Coin c = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ci = c.x + posi[k]*map[c.x][c.y];
				int cj = c.y + posj[k]*map[c.x][c.y];
				if(ci < 0 || cj < 0 || ci >= N || cj >= M || map[ci][cj] == 0){
					answer = Math.max(answer, c.count);
					if(answer > N*M){
						answer = -1;
						return;
					}
					continue;
				}
				if(visited[ci][cj] < c.count + 1){
					visited[ci][cj] = c.count + 1;
					queue.add(new Coin(ci, cj, c.count + 1));
				} else{
					continue;
				}
			}
		}
	}
}

/*
24 24
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
12H12H12H12H12H12H12H12H
2HH2HH2HH2HH2HH2HH2HH2HH
HHHHHHHHHHHHHHHHHHHHHHHH
*/