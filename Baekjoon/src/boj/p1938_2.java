package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class TreePt {
	int i;
	int j;

	public TreePt(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class TTree {
	TreePt[] treeArr;
	int count;

	public TTree(TreePt[] treeArr, int count) {
		this.treeArr = treeArr;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return treeArr[0].i + ", " + treeArr[0].j + " / " + treeArr[1].i + ", " + treeArr[1].j + " / " +treeArr[2].i + ", " + treeArr[2].j + "("+count+")";
	}
}

public class p1938_2 {

	static HashMap<String, Integer> visitMap;
	static int[][] map;
	static int N, answer;
	static Queue<TTree> queue;
	static int[] posI1 = { -1, 1, 0, 0 };
	static int[] posJ1 = { 0, 0, -1, 1 };
	static int[] posI2 = { -1, 1, 0, 0 };
	static int[] posJ2 = { 0, 0, -1, 1 };
	static int[] posI3 = { -1, 1, 0, 0 };
	static int[] posJ3 = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		TreePt[] curPointArr = new TreePt[3];
		visitMap = new HashMap<>();

		int index = 0;
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = inp.charAt(j);
				if (c == 'E') {
					map[i][j] = -1;
					continue;
				}
				if (c == 'B') {
					curPointArr[index] = new TreePt(i, j);
					map[i][j] = 0;
					index++;
				}
				else
					map[i][j] = c - '0';
			}
		}
		TTree tree = new TTree(curPointArr, 0);
		moveTongTree(tree);
		System.out.println(answer);
	}

	// 상 하 좌 우 회전
	public static void moveTongTree(TTree tree) {
		queue = new LinkedList<>();
		queue.add(tree);
		visitMap.put(tree.treeArr[0].i + "-" + tree.treeArr[0].j + "-" + tree.treeArr[1].i + "-" + tree.treeArr[1].j
				+ "-" + tree.treeArr[2].i + "-" + tree.treeArr[2].j, 1);
		visitMap.put(tree.treeArr[2].i + "-" + tree.treeArr[2].j + "-" + tree.treeArr[1].i + "-" + tree.treeArr[1].j
				+ "-" + tree.treeArr[0].i + "-" + tree.treeArr[0].j, 1);
		while (!queue.isEmpty()) {
			TTree t = queue.poll();
			if (map[t.treeArr[0].i][t.treeArr[0].j] + map[t.treeArr[1].i][t.treeArr[1].j] + map[t.treeArr[2].i][t.treeArr[2].j] == -3) {
				answer = t.count;
				return;
			}
			for (int i = 0; i < 4; i++) {
				int ni1 = t.treeArr[0].i + posI1[i];
				int nj1 = t.treeArr[0].j + posJ1[i];
				int ni2 = t.treeArr[1].i + posI2[i];
				int nj2 = t.treeArr[1].j + posJ2[i];
				int ni3 = t.treeArr[2].i + posI3[i];
				int nj3 = t.treeArr[2].j + posJ3[i];
				if (ni1 < 0 || nj1 < 0 || ni2 < 0 || nj2 < 0 || ni3 < 0 || nj3 < 0 || ni1 >= N || nj1 >= N || ni2 >= N
						|| nj2 >= N || ni3 >= N || nj3 >= N)
					continue;
				if (map[ni1][nj1] == 1 || map[ni2][nj2] == 1 || map[ni3][nj3] == 1
						|| visitMap.get(ni1 + "-" + nj1 + "-" + ni2 + "-" + nj2 + "-" + ni3 + "-" + nj3) != null)
					continue;
				queue.add(new TTree(new TreePt[] { new TreePt(ni1, nj1), new TreePt(ni2, nj2), new TreePt(ni3, nj3) },
						t.count + 1));
				visitMap.put(ni1 + "-" + nj1 + "-" + ni2 + "-" + nj2 + "-" + ni3 + "-" + nj3, 1);
				visitMap.put(ni3 + "-" + nj3 + "-" + ni2 + "-" + nj2 + "-" + ni1 + "-" + nj1, 1);
			}
			rotateTree(t);
		}

	}

	public static void rotateTree(TTree t) {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int ni = t.treeArr[1].i + i;
				int nj = t.treeArr[1].j + j;
				if (ni < 0 || nj < 0 || ni >= N || nj >= N || map[ni][nj] == 1)
					return;
			}
		}
		int ni1 = 0, nj1 = 0, ni3 = 0, nj3 = 0;
		int ni2 = t.treeArr[1].i;
		int nj2 = t.treeArr[1].j;
		if (t.treeArr[0].i == t.treeArr[1].i) {
			ni1 = t.treeArr[0].i - 1;
			nj1 = t.treeArr[0].j + 1;
			ni3 = t.treeArr[2].i + 1;
			nj3 = t.treeArr[2].j - 1;
		} else {
			ni1 = t.treeArr[0].i + 1;
			nj1 = t.treeArr[0].j - 1;
			ni3 = t.treeArr[2].i - 1;
			nj3 = t.treeArr[2].j + 1;
		}
		if (visitMap.get(ni1 + "-" + nj1 + "-" + ni2 + "-" + nj2 + "-" + ni3 + "-" + nj3) != null)
			return;
		queue.add(new TTree(
				new TreePt[] { new TreePt(ni1, nj1), new TreePt(ni2, nj2), new TreePt(ni3, nj3) },
				t.count + 1));
		visitMap.put(ni1 + "-" + nj1 + "-" + ni2 + "-" + nj2 + "-" + ni3 + "-" + nj3, 1);
		visitMap.put(ni3 + "-" + nj3 + "-" + ni2 + "-" + nj2 + "-" + ni1 + "-" + nj1, 1);
	}

}
