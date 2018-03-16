package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

첫 번째 줄에는 보드의 세로/가로 크기를 의미하는 두 정수 N, M (3 ≤ N, M ≤ 10)이 주어진다. 
다음 N개의 줄에 보드의 모양을 나타내는 길이 M의 문자열이 주어진다. 이 문자열은 '.', '#', 'O', 'R', 'B' 로만으로 이루어져 있다. 
'.'은 빈 칸을 의미하고, '#'은 공이 이동할 수 없는 장애물 또는 벽을 의미하며, 'O'는 구멍의 위치를 의미한다. 'R'은 빨간 구슬의 위치, 'B'는 파란 구슬의 위치이다.

왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기.

각각의 동작에서 공은 동시에 움직이게 되며, 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. 
빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. 
또, 빨간 구슬과 파란 구슬의 크기는 격자의 한 칸을 모두 차지한다. 

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
	static int[] posY = { 0, 0, -1, 1 }; // 상 하 좌 우

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
	// 빨간 공 & 파란 공 인접한 경우 생각.
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
