package boj;
/*
 * �׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
 * ��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, 
 * �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.
 * 
 * ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. 
 * ���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. �� ������ ���� �� �־��� ���� �ִµ�, ������ �ϳ��� �ִ� ������ �����ϸ� �ȴ�. 
 * �Է����� �־����� ������ ������̴�.
 * 
 * ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.
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
