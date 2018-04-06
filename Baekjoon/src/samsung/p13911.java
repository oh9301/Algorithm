package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class HouseEdge{
	int v;
	int w;
	
	public HouseEdge(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
}
/*
집구하기 : BOJ13911
- 초기 접근 방식 - 

Dijkstra를 맥도날드, 스타벅스 지점별로 각각 계산.
x, y보다 작은 조건 만족하는 곳 찾아내기

but, 입력값 범위가 크다.
맥도날드 다익스트라 최대 (V-2)번 : O(E*log(V)) * V-2번
스타벅스 다익스트라 최대 (V-2)번 : O(E*log(V)) * V-2번
조건 만족 찾아내기 : (V-2)^2 ?
위 바업은 시간복잡도가 폭발한다!

- 해결법 : Dummy Node 활용 -

더미노드(V+1)를 하나 생성, 맥도날드 지점과 연결 (COST : 0)
더미노드(V+2)를 하나 생성, 스타벅스 지점과 연결 (COST : 0)
더미노드 V+1, V+2에서 다익스트라 수행.
-> dist(최단거리 배열) 반환.
* 조건 비교 -> CLEAR 

참고 : http://stack07142.tistory.com/172
*/
public class p13911 {
	
	static final int INF = 100000001;
	static int V, E, M, S;
	static int x, y;
	static ArrayList<ArrayList<HouseEdge>> mlist;
	static int answer;

	public static void main(String[] args) throws IOException {
		answer = INF;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		mlist = new ArrayList<>();
		for (int i = 0; i <= V+2; i++)
			mlist.add(new ArrayList<>());
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			mlist.get(u).add(new HouseEdge(v, w));
			mlist.get(v).add(new HouseEdge(u, w));
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++)
			mlist.get(V+1).add(new HouseEdge(Integer.parseInt(st.nextToken()), 0));
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < S; i++)
			mlist.get(V+2).add(new HouseEdge(Integer.parseInt(st.nextToken()), 0));
		
		int[] dist1 = getMinPath(V+1);
		int[] dist2 = getMinPath(V+2);
		for (int i = 1; i <= V; i++) {
			if(dist1[i] == 0 || dist2[i] == 0)
				continue;
			if(dist1[i] <= x && dist2[i] <= y){
				answer = Math.min(answer, dist1[i] + dist2[i]);
			}
		}
		System.out.println((answer == INF) ? -1 : answer);
	}
	
	public static int[] getMinPath(int start){
		int[] dist = new int[V+3];
		boolean[] visited = new boolean[V+3];
		for (int i = 0; i <= V+2; i++) {
			dist[i] = INF;
		}
		dist[start] = 0;
		for (int i = 1; i <= V+2; i++) {
			int minV = -1;
			int minW = INF;
			for (int j = 1; j <= V+2; j++) {
				if(!visited[j] && dist[j] < minW){
					minV = j;
					minW = dist[j];
				}
			}
			if(minV == -1)
				return dist;
			visited[minV] = true;
			for (HouseEdge e : mlist.get(minV)) {
				if(!visited[e.v]){
					if(dist[e.v] > dist[minV] + e.w)
						dist[e.v] = dist[minV] + e.w;
				}
			}
		}
		return dist;
	}

}
