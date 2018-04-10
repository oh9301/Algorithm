package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line2 implements Comparable<Line2>{
	int v;
	long w;
	
	public Line2(int v, long w) {
		this.v = v;
		this.w = w;
	}
	
	@Override
	public int compareTo(Line2 o) {
		
		return (this.w - o.w > 0) ? 1 : -1;
	}
}

public class p1803 {
	
	static final long INF = Long.MAX_VALUE;
	static int N, M, sp, ep;
	static long answer;
	static ArrayList<ArrayList<Line2>> mlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sp = Integer.parseInt(st.nextToken());
			ep = Integer.parseInt(st.nextToken());
			mlist = new ArrayList<>();
			for (int i = 0; i <= N; i++)
				mlist.add(new ArrayList<>());
			
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				mlist.get(u).add(new Line2(v, w));
				mlist.get(v).add(new Line2(u, w));
			}
			
			answer = dijkstra(sp, ep);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static long dijkstra(int start, int end){
		long [] dist = new long[N+1];
		boolean [] visited = new boolean[N+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		PriorityQueue<Line2> queue = new PriorityQueue<>();
		queue.offer(new Line2(start, dist[start]));
		while(!queue.isEmpty()){
			Line2 elem = queue.poll();
			long d = elem.w;
			int v = elem.v;
			if(d > dist[v])
				continue;
			for (Line2 l : mlist.get(elem.v)) {
				if(!visited[l.v] && dist[l.v] > dist[v] + l.w){
					dist[l.v] = dist[v] + l.w;
					queue.offer(new Line2(l.v, dist[v] + l.w));
				}
			}
		}
		return dist[end];
	}

}
