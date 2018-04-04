package boj;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

class Edge {
	int v;
	int w;

	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}

}

public class p1916 {

	static int n, m;
	static int answer;
	static ArrayList<ArrayList<Edge>> path;
	static final int MAXVAL = 1000000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		path = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			path.add(i, new ArrayList<Edge>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			path.get(r).add(new Edge(v, w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		answer = getMinPath(start, end);
		System.out.println(answer);
	}

	public static int getMinPath(int start, int end) {
		int[] dist = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i = 0; i < dist.length; i++) {
			dist[i] = MAXVAL;
		}
		dist[start] = 0;
		for (int k = 1; k <= n; k++) {
			int minV = -1;
			int minW = MAXVAL;
			for (int j = 1; j <= n; j++) {
				if (!visited[j] && dist[j] < minW) {
					minV = j;
					minW = dist[j];
				}
			}
			if (minV == -1)
				return dist[end];
			visited[minV] = true;
			for (Edge e : path.get(minV)) {
				if (!visited[e.v]) {
					int curD = dist[e.v];
					int newD = e.w;
					if (curD > newD + dist[minV]) {
						dist[e.v] = newD + dist[minV];
					}
				}
			}
		}
		return dist[end];
	}
}