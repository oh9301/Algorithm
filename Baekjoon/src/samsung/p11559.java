package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Point_puyo {
	int row;
	int col;

	Point_puyo(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class p11559 {

	static char[][] map;
	static int answer;
	static int[] posx = { -1, 0, 1, 0 };
	static int[] posy = { 0, -1, 0, 1 };
	static ArrayList<Point_puyo> tmp;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][6];
		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++)
				map[i][j] = str.charAt(j);
		}

		while (true) {
			int count = 0;
			visited = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && !visited[i][j]) {
						tmp = new ArrayList<>();
						visited[i][j] = true;
						DFS(0, i, j, map[i][j]);
						if (tmp.size() >= 4) {
							for (Point_puyo p : tmp)
								map[p.row][p.col] = '.';
							count++;
						}
					}
				}
			}
			if (count == 0)
				break;
			for (int col = 0; col < 6; col++)
				descendPuyo(col);
			answer++;
		}
		System.out.println(answer);
	}

	public static void DFS(int count, int i, int j, char c) {
		tmp.add(new Point_puyo(i, j));
		for (int t = 0; t < 4; t++) {
			int ni = i + posx[t];
			int nj = j + posy[t];
			if (ni < 0 || nj < 0 || ni >= 12 || nj >= 6 || map[ni][nj] != c || visited[ni][nj])
				continue;
			visited[ni][nj] = true;
			DFS(count + 1, ni, nj, c);
		}
	}

	public static void descendPuyo(int col){
		for (int i = 10; i >= 0; i--) {
			if(map[i][col] != '.'){
				int start = i;
				while(map[start][col] != '.' && start < 11){
					if(map[start+1][col] == '.'){
						map[start+1][col] = map[start][col];
						map[start][col] = '.';
					} else
						break;
					start = start + 1;
				}
			}
		}
	}
}
