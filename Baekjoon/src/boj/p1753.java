package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// ���ͽ�Ʈ�� �˰��� �н��� �ڵ�.
// ���� - 1753(�ִܰ��) ���ͽ�Ʈ�� �˰��� JAVA Ǯ��.
// ������ķ� Ǫ�� ���
// ���� �ִ� ������ 20000�̶� 20000 * 20000 �迭 ����� ��Ÿ�� ����(�޸� �ʰ�)
// ���� ����� �����Ͽ� �޸� ���ϸ� ���̴� ���

public class p1753 {
	static ArrayList<ArrayList<Line>> ad;
	static int V;
	static int E;
	static int[] distance;
	public static void main(String[] args) throws IOException {
		//�Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		distance = new int[V+1];
		ad = new ArrayList<ArrayList<Line>>();
		//���� ����Ʈ�� �Ÿ��迭 ����
		for(int i=0; i<=V; i++) {
			distance[i] = Integer.MAX_VALUE;
			ad.add(i,new ArrayList<Line>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			ad.get(u).add(new Line(v,w));
		}
		//���ͽ�Ʈ�� �˰���
		dijkstra(K);
		//��� ���
		for(int i=1; i<distance.length; i++) {
			if(distance[i] == Integer.MAX_VALUE) 
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
	}
	
	public static void dijkstra(int K) {
		PriorityQueue<Line> q = new PriorityQueue<>();
		distance[K] = 0;
		q.offer(new Line(K, distance[K]));
		
		while(!q.isEmpty()) {
			int dist = q.peek().getW();
			int nowV = q.peek().getV();
			q.poll();
			
			if(dist > distance[nowV]) continue;
			
			for(Line line : ad.get(nowV)) {
				int nextV = line.getV();
				int nextW = line.getW();
				if(distance[nextV] > distance[nowV] + nextW){
					distance[nextV] = distance[nowV] + nextW;
					q.offer(new Line(nextV, distance[nextV]));
				}
			}
		}
	}
}
 
class Line implements Comparable<Line>{
	private int v;
	private int w;
	
	public Line(int v, int w) {
		this.v = v;
		this.w = w;
	}
	
	public int getV() {
		return v;
	}
 
 
	public int getW() {
		return w;
	}
 
	@Override
	public int compareTo(Line o) {
		return this.w - o.w;
	}	
}