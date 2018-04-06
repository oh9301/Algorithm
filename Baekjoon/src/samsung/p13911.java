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
�����ϱ� : BOJ13911
- �ʱ� ���� ��� - 

Dijkstra�� �Ƶ�����, ��Ÿ���� �������� ���� ���.
x, y���� ���� ���� �����ϴ� �� ã�Ƴ���

but, �Է°� ������ ũ��.
�Ƶ����� ���ͽ�Ʈ�� �ִ� (V-2)�� : O(E*log(V)) * V-2��
��Ÿ���� ���ͽ�Ʈ�� �ִ� (V-2)�� : O(E*log(V)) * V-2��
���� ���� ã�Ƴ��� : (V-2)^2 ?
�� �پ��� �ð����⵵�� �����Ѵ�!

- �ذ�� : Dummy Node Ȱ�� -

���̳��(V+1)�� �ϳ� ����, �Ƶ����� ������ ���� (COST : 0)
���̳��(V+2)�� �ϳ� ����, ��Ÿ���� ������ ���� (COST : 0)
���̳�� V+1, V+2���� ���ͽ�Ʈ�� ����.
-> dist(�ִܰŸ� �迭) ��ȯ.
* ���� �� -> CLEAR 

���� : http://stack07142.tistory.com/172
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
