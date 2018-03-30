package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point_Map{
	int i;
	int j;
	int count;
	
	public Point_Map(int i, int j, int count) {
		this.i = i;
		this.j = j;
		this.count = count;
	}
	
}

public class p5427 {
	
	static int h, w;
	static int[][] visited;
	static char[][] map;
	static Queue<Point_Map> fireQueue;
	static Queue<Point_Map> pQueue;
	static int[] dist;
	static int[] posI = {-1, 0, 1, 0};
	static int[] posJ = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			visited = new int[h][w];
			pQueue = new LinkedList<>();
			fireQueue = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String inp = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = inp.charAt(j);
					if(map[i][j] == '@'){
						pQueue.add(new Point_Map(i, j, 0));
						visited[i][j] = 1;
					}
					else if(map[i][j] == '*'){
						fireQueue.add(new Point_Map(i, j, 0));
						visited[i][j] = 2;
					}
				}
			}
			System.out.println(BFS());
		}
	}
	
	public static String BFS(){
		// 불 먼저 번지기.
		Queue<Point_Map> npQueue = new LinkedList<>();
		Queue<Point_Map> nfQueue = new LinkedList<>();
		while(!pQueue.isEmpty()){
			for (Point_Map p : pQueue) {
				if(visited[p.i][p.j] == 2)
					continue;
				for (int k = 0; k < 4; k++) {
					int ni = p.i + posI[k];
					int nj = p.j + posJ[k];
					if(ni < 0 || nj < 0 || ni >= h || nj >= w)
						return (p.count + 1) + "";
					if(map[ni][nj] == '#' || visited[ni][nj] > 0)
						continue;
					visited[ni][nj] = 1;
					npQueue.add(new Point_Map(ni, nj, p.count + 1));
				}
			}
			for (Point_Map fp : fireQueue) {
				for (int k = 0; k < 4; k++) {
					int ni = fp.i + posI[k];
					int nj = fp.j + posJ[k];
					if(ni < 0 || nj < 0 || ni >= h || nj >= w || map[ni][nj] == '#' || visited[ni][nj] == 2)
						continue;
					visited[ni][nj] = 2;
					nfQueue.add(new Point_Map(ni, nj, 0));
				}
			}
			pQueue.clear();
			pQueue.addAll(npQueue);
			npQueue.clear();
			fireQueue.clear();
			fireQueue.addAll(nfQueue);
			nfQueue.clear();
		}
		return "IMPOSSIBLE";
	}

}
