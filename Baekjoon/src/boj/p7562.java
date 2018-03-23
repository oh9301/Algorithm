package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N_Point {
	int i;
	int j;

	public N_Point(int i, int j) {
		this.i = i;
		this.j = j;
	}

}

public class p7562 {

	static int l, goal_i, goal_j;
	static int[] posI = { 2, 2, 1, 1, -2, -2, -1, -1 };
	static int[] posJ = { 1, -1, 2, -2, 1, -1, 2, -2 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			l = Integer.parseInt(br.readLine());
			visited = new boolean[l][l];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cur_i = Integer.parseInt(st.nextToken());
			int cur_j = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			goal_i = Integer.parseInt(st.nextToken());
			goal_j = Integer.parseInt(st.nextToken());

			System.out.println(moveNight(0, cur_i, cur_j));
		}
	}

	public static int moveNight(int cnt, int i, int j) {
		int answer = 0;
		Queue<N_Point> queue = new LinkedList<>();
		Queue<N_Point> nextQueue = new LinkedList<>();
		queue.add(new N_Point(i, j));
		visited[i][j] = true;

		while (!queue.isEmpty()) {
			for (N_Point np : queue) {
				if(np.i == goal_i && np.j == goal_j)
					return answer;
				for (int k = 0; k < 8; k++) {
					int ni = np.i + posI[k];
					int nj = np.j + posJ[k];
					if (ni < 0 || nj < 0 || ni >= l || nj >= l || visited[ni][nj])
						continue;
					visited[ni][nj] = true;
					nextQueue.add(new N_Point(ni, nj));
				}
			}
			queue.clear();
			queue.addAll(nextQueue);
			nextQueue.clear();
			answer++;
		}
		
		return answer;
	}

}
