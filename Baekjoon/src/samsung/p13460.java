package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

ù ��° �ٿ��� ������ ����/���� ũ�⸦ �ǹ��ϴ� �� ���� N, M (3 �� N, M �� 10)�� �־�����. 
���� N���� �ٿ� ������ ����� ��Ÿ���� ���� M�� ���ڿ��� �־�����. �� ���ڿ��� '.', '#', 'O', 'R', 'B' �θ����� �̷���� �ִ�. 
'.'�� �� ĭ�� �ǹ��ϰ�, '#'�� ���� �̵��� �� ���� ��ֹ� �Ǵ� ���� �ǹ��ϸ�, 'O'�� ������ ��ġ�� �ǹ��Ѵ�. 'R'�� ���� ������ ��ġ, 'B'�� �Ķ� ������ ��ġ�̴�.

�������� ����̱�, ���������� ����̱�, �������� ����̱�, �Ʒ������� ����̱�.

������ ���ۿ��� ���� ���ÿ� �����̰� �Ǹ�, ���� ������ ���ۿ� ������ ����������, �Ķ� ������ ���ۿ� ������ �����̴�. 
���� ������ �Ķ� ������ ���ÿ� ���ۿ� ������ �����̴�. ���� ������ �Ķ� ������ ���ÿ� ���� ĭ�� ���� �� ����. 
��, ���� ������ �Ķ� ������ ũ��� ������ �� ĭ�� ��� �����Ѵ�. 

5 5
#####
#..B#
#.#.#
#RO.#
#####

1
*/

public class p13460 {

	static int answer;
	static char[][] board;
	static int N, M;
	static int curbX, curbY;
	static int currX, currY;
	static int[] posX = { -1, 1, 0, 0 };
	static int[] posY = { 0, 0, -1, 1 }; // �� �� �� ��

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int startBx = 0, startBy = 0;
		int startRx = 0, startRy = 0;
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
				if (board[i][j] == 'B') {
					startBx = i;
					startBy = j;
				} else if (board[i][j] == 'R') {
					startRx = i;
					startRy = j;
				}
			}
		}
		answer = 11;
		leanBoard(startRx, startRy, startBx, startBy, 1);
		if (answer > 10)
			answer = -1;
		System.out.println(answer);
	}

	// BFS(leanBoard) + DFS(moveBall)
	//
	// ���� �� & �Ķ� �� ������ ��� ����.
	public static void leanBoard(int rx, int ry, int bx, int by, int cnt) {
		int f = 0;
		if (cnt >= answer)
			return;
		for (int i = 0; i < 4; i++) {
			f = 0;
			if (searchLineBall(i, rx, ry, bx, by) == 1) {
				f += moveBall(rx, ry, i, 'R', 'B');
				f += moveBall(bx, by, i, 'B', 'R');
			} else {
				f += moveBall(bx, by, i, 'B', 'R');
				f += moveBall(rx, ry, i, 'R', 'B');
			}

			if (f > 0)
				answer = Math.min(answer, cnt);
			else if (f == 0)
				leanBoard(currX, currY, curbX, curbY, cnt + 1);
			if(board[currX][currY] != 'O')
				board[currX][currY] = '.';
			if(board[curbX][curbY] != 'O')
				board[curbX][curbY] = '.';
		}

	}

	public static int searchLineBall(int dir, int rx, int ry, int bx, int by) {
		int res = 0;
		if (dir == 0 && ry == by)
			res = (rx > bx) ? -1 : 1;
		else if (dir == 1 && ry == by)
			res = (rx > bx) ? 1 : -1;
		else if (dir == 2 && rx == bx)
			res = (ry > by) ? -1 : 1;
		else if (dir == 3 && rx == bx)
			res = (ry > by) ? 1 : -1;

		return res;
	}

	public static int moveBall(int cX, int cY, int dir, char inc, char disc) {
		int res = 0;
		if (inc == 'B') {
			curbX = cX;
			curbY = cY;
		} else {
			currX = cX;
			currY = cY;
		}
		if (board[cX][cY] == 'O') {
			return (inc == 'B') ? -2 : 1;
		}
		board[cX][cY] = inc;
		int nX = cX + posX[dir];
		int nY = cY + posY[dir];
		if (nX >= 0 && nY >= 0 && nX < N && nY < M && board[nX][nY] != '#' && board[nX][nY] != disc) {
			board[cX][cY] = '.';
			res += moveBall(nX, nY, dir, inc, disc);
		}
		return res;
	}

}
