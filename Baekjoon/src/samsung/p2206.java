package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class WPoint{
	int x;
	int y;
	int w;
	int len;
	
	public WPoint(int x, int y, int w, int len) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.len = len;
	}
	
}

public class p2206 {
	
	static int N, M, answer = -1;
	static int[][] map;
	static boolean[][][] visited;
	static int[] posX = {-1, 0, 1, 0};
	static int[] posY = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = inp.charAt(j) - '0';
		}
		execBFS();
		System.out.println(answer);
	}

	public static void execBFS(){
		Queue<WPoint> queue = new LinkedList<>();
		queue.add(new WPoint(0, 0, 1, 1));
		visited[0][0][1] = true;
		while(!queue.isEmpty()){
			WPoint wp = queue.poll();
			if(wp.x == N-1 && wp.y == M-1){
				answer = wp.len;
				return;
			}
			for (int t = 0; t < 4; t++) {
				int nx = wp.x + posX[t];
				int ny = wp.y + posY[t];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][wp.w])
					continue;
				if(map[nx][ny] == 1){
					if(wp.w == 1){
						visited[nx][ny][wp.w - 1] = true;
						queue.add(new WPoint(nx, ny, wp.w - 1, wp.len + 1));
					}
				} else{
					visited[nx][ny][wp.w] = true;
					queue.add(new WPoint(nx, ny, wp.w, wp.len + 1));
				}
			}
		}
	}
}
/*
8 8
01000100
01010100
01010100
01010100
01010100
01010100
01010100
00010100
*/
