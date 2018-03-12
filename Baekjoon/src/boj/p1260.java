package boj;
/*
 * 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
 * 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
 * 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
 * 
 * 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
 * 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 한 간선이 여러 번 주어질 수도 있는데, 간선이 하나만 있는 것으로 생각하면 된다. 
 * 입력으로 주어지는 간선은 양방향이다.
 * 
 * 첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
 */
/*
4 5 1
1 2
1 3
1 4
2 4
3 4

6 6 1
1 2
1 3
1 4
5 4
5 6
3 2

6 6 1
1 2
1 3
1 5 
5 4
5 6
3 2

1 2 4 3
1 2 3 4
*/

import java.util.ArrayList;
import java.util.Scanner;

public class p1260 {
	
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		int[][] gp = new int[N+1][N+1];
		int[][] gp2 = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			int ix = sc.nextInt();
			int iy = sc.nextInt();
			gp[ix][iy] = 1;
			gp[iy][ix] = 1;
			gp2[ix][iy] = 1;
			gp2[iy][ix] = 1;
		}
		
		int[] visitD = new int[N+1];
		int[] visitB = new int[N+1];
		execDFS(V, gp, visitD);
		System.out.println();
		execBFS(V, gp2, visitB);
	}
	
	public static void execDFS(int start, int[][] gp, int[] visit){
		System.out.print(start+" ");
		visit[start] = 1;
		for (int i = 1; i < gp.length; i++) {
			if(gp[start][i] == 1 && visit[i] == 0){
				gp[start][i] = 0;
				gp[i][start] = 0;
				execDFS(i, gp, visit);
			}
		}
	}
	
	public static void execBFS(int start, int[][] gp, int[] visit){
		ArrayList<Integer> queue = new ArrayList<>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			int n = queue.remove(0);
			System.out.print(n+ " ");
			for (int i = 1; i < gp.length; i++) {
				if(gp[n][i] == 1 && visit[i] == 0){
					queue.add(i);
					gp[i][n] = 0;
					gp[n][i] = 0;
					visit[i] = 1;
				}
			}
		}
	}

}
