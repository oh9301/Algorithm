package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Beaver{
	int i;
	int j;
	int count;
	
	public Beaver(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}
	
}

public class p3055 {
	static int answer, R, C;
	static char[][] map;
	static int[][] visited;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int start_i = 0;
		int start_j = 0;
		map = new char[R][C];
		visited = new int[R][C];
		Queue<Beaver> fireQueue = new LinkedList<>();
		
		for (int i = 0; i < R; i++) {
			String inp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = inp.charAt(j);
				if(map[i][j] == 'S'){
					start_i = i;
					start_j = j;
					visited[i][j] = 1;
				} else if(map[i][j] == '*'){
					fireQueue.offer(new Beaver(i, j, 0));
					visited[i][j] = 2;
				}
			}
		}
		BFS(start_i, start_j, fireQueue);
		System.out.println((answer == 0) ? "KAKTUS" : answer);
	}

	public static void BFS(int start_i, int start_j, Queue<Beaver> fireQueue){
		Queue<Beaver> queue = new LinkedList<>();
		Queue<Beaver> nqueue = new LinkedList<>();
		Queue<Beaver> nfqueue = new LinkedList<>();
		queue.add(new Beaver(start_i, start_j, 0));
		while(!queue.isEmpty()){
			for(Beaver bv : queue){
				if(visited[bv.i][bv.j] == 2)
					continue;
				if(map[bv.i][bv.j] == 'D'){
					answer = bv.count;
					return;
				}
				for (int k = 0; k < 4; k++) {
					int ni = bv.i + posi[k];
					int nj = bv.j + posj[k];
					if(ni < 0 || nj < 0 || ni >= R || nj >= C || map[ni][nj] == 'X' || visited[ni][nj] > 0)
						continue;
					visited[ni][nj] = 1;
					nqueue.add(new Beaver(ni, nj, bv.count + 1));
				}
			}
			
			for(Beaver fv : fireQueue){
				for (int k = 0; k < 4; k++) {
					int ni = fv.i + posi[k];
					int nj = fv.j + posj[k];
					if(ni < 0 || nj < 0 || ni >= R || nj >= C || map[ni][nj] == 'X' || map[ni][nj] == 'D' || visited[ni][nj] == 2)
						continue;
					visited[ni][nj] = 2;
					nfqueue.add(new Beaver(ni, nj, 0));
				}
			}
			queue.clear();
			queue.addAll(nqueue);
			nqueue.clear();
			fireQueue.clear();
			fireQueue.addAll(nfqueue);
			nfqueue.clear();
		}
	}
}
