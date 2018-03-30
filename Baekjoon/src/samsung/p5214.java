package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5214 {
	
	static int N, M, K;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	static int[] dArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		visited = new boolean[N+M+1];
		for (int i = 0; i < N+M+1; i++) 
			arr.add(new ArrayList<>());
		for (int i = 1; i <= M; i++) {
			int tNode = N + i;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int node = Integer.parseInt(st.nextToken());
				arr.get(node).add(tNode);
				arr.get(tNode).add(node);
			}
		}
		BFS();
		System.out.println((dArr[N] == 0) ? -1 : (dArr[N]+1)/2);
	}
	
	public static void BFS(){
		Queue<Integer> queue = new LinkedList<>();
		dArr = new int[N+M+1]; 
		queue.add(1);
		dArr[1] = 1;
		while(!queue.isEmpty()){
			int num = queue.poll();
			if(N == num)
				return;
			for(int nNode : arr.get(num)){
				if(!visited[nNode]){
					visited[nNode] = true;
					dArr[nNode] = dArr[num] + 1;
					queue.add(nNode);
				}
			}
		}
	}

}
