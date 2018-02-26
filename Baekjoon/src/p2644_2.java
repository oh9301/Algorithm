import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2644_2 {
	public static int[][] relations;
	public static int[] chk;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int m = sc.nextInt();
		relations = new int[n + 1][n + 1];
		chk = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int t1 = sc.nextInt();
			int t2 = sc.nextInt();
			relations[t1][t2] = 1;
			relations[t2][t1] = 1;
		}
		System.out.println(dfs(x, y));
		sc.close();
	}

	public static int dfs(int x, int y) {
		System.out.println(x);
		if (x == y) {
			return 0;
		}
		for (int i = 1; i < relations.length; i++) {
			if (relations[x][i] == 1 && chk[i] == 0) {
				chk[i] = 1;
				int temp = dfs(i, y);
				if(temp == 0)
					return 1 + temp;
			}
		}
		return -1;
	}

	public static int bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		while (!q.isEmpty()) {
			int i = q.poll();
			if (i == y) {
				return chk[y];
			}
			for (int j = 1; j < relations.length; j++) {
				if (relations[i][j] == 1 && chk[j] == 0) {
					q.add(j);
					chk[j] = chk[i] + 1;
				}
			}
		}
		return -1;
	}
}

/*
 * 10 8 10 9 1 2 1 3 2 4 2 5 3 6 3 7 4 8 4 9 6 10
 * 
 * 6
 * 
 * 9 7 3 7 1 2 1 3 2 7 2 8 2 9 4 5 4 6
 * 
 * 3
 * 
 * 
9 
4 3
7
1 2
1 3
1 4
2 8
2 9
4 5
4 6
 
 * -1
 * 
 * 
 */
