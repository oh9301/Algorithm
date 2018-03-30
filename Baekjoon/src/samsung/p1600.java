package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Monkey{
	int i;
	int j;
	int count;
	int hsize;
	
	public Monkey(int i, int j, int count, int hsize) {
		this.i = i;
		this.j = j;
		this.count = count;
		this.hsize = hsize;
	}
	
}

public class p1600 {
	
	static int K, W, H;
	static int answer = -1;
	static int[][] map;
	static int[][][] visited;
	static int[] horsei = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] horsej = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new int[K+1][H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		BFS();
		System.out.println(answer);
	}

	public static void BFS(){
		Queue<Monkey> queue = new LinkedList<>();
		queue.add(new Monkey(0, 0, 0, K));
		visited[K][0][0] = 1;
		while(!queue.isEmpty()){
			Monkey m = queue.poll();
			if(m.i == H - 1 && m.j == W - 1){
				answer = m.count;
				return;
			}
			if(m.hsize > 0){
				for (int t = 0; t < 8; t++) {
					int ni = m.i + horsei[t];
					int nj = m.j + horsej[t];
					if(ni < 0 || nj < 0 || ni >= H || nj >= W || map[ni][nj] == 1)
						continue;
					if(visited[m.hsize - 1][ni][nj] == 0 || visited[m.hsize - 1][ni][nj] > m.count + 1){
						visited[m.hsize - 1][ni][nj] = m.count + 1;
						queue.offer(new Monkey(ni, nj, m.count + 1, m.hsize - 1));
					}
				}
			}
			for (int k = 0; k < 4; k++) {
				int ni = m.i + posi[k];
				int nj = m.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= H || nj >= W || map[ni][nj] == 1)
					continue;
				if(visited[m.hsize][ni][nj] == 0 || visited[m.hsize][ni][nj] > m.count + 1){
					visited[m.hsize][ni][nj] = m.count + 1;
					queue.offer(new Monkey(ni, nj, m.count + 1, m.hsize));
				}
			}
		}
	}
}
