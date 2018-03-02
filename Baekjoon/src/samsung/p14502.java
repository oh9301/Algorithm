package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int row;
	int col;

	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class p14502 {

	static int answer = 64;
	static int N;
	static int M;
	static int zeroCnt;
	static int virusCnt;
	static ArrayList<Point> pList;
	static ArrayList<Point> virusList;
	static int[][] map;
	static int[] dirX = { -1, 1, 0, 0 };
	static int[] dirY = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		zeroCnt = 0;
		virusCnt = 0;
		map = new int[N][M];
		pList = new ArrayList<>();
		virusList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					pList.add(new Point(i, j));
					zeroCnt++;
				} else if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
					virusCnt++;
				}
			}
		}

		if (virusCnt == 0)
			answer = zeroCnt - 3;
		else
			selectWallPoint(0, new int[3][2], 0);
		System.out.println(zeroCnt - answer + virusCnt - 3);

	}

	public static void selectWallPoint(int index, int[][] tmpArr, int len) {
		if (len == 3) {
			// BFS DEF
			int res = calcSafetyArea(tmpArr);
			answer = (answer > res) ? res : answer;
			return;
		}
		for (int i = index; i < pList.size(); i++) {
			tmpArr[len][0] = pList.get(i).row;
			tmpArr[len][1] = pList.get(i).col;
			selectWallPoint(i + 1, tmpArr, len + 1);
		}
	}

	public static int calcSafetyArea(int[][] wallArr) {
		int sum = 0;
		boolean[][] visit = new boolean[N][M];
		for (int[] wall : wallArr)
			visit[wall[0]][wall[1]] = true;

		ArrayList<Point> queue = (ArrayList<Point>) virusList.clone();
		while (!queue.isEmpty()) {
			Point p = queue.remove(0);
			if (visit[p.row][p.col])
				continue;
			visit[p.row][p.col] = true;
			for (int i = 0; i < 4; i++) {
				int nrow = p.row + dirY[i];
				int ncol = p.col + dirX[i];

				if (nrow < 0 || ncol < 0 || nrow >= N || ncol >= M || map[nrow][ncol] == 1 || map[nrow][ncol] == 2
						|| visit[nrow][ncol])
					continue;
				queue.add(new Point(nrow, ncol));
			}
			sum++;
		}
		return sum;
	}

}
