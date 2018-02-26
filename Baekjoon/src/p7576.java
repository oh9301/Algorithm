import java.util.ArrayList;
import java.util.Scanner;

public class p7576 {

	static int answer = -1;
	static int M;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int zeroCnt = 0;
		int[][] tArr = new int[M][N];
		int[] dirX = { 1, -1, 0, 0 };
		int[] dirY = { 0, 0, 1, -1 };
		ArrayList<int[]> queueList = new ArrayList<int[]>();
		ArrayList<int[]> nextList = new ArrayList<int[]>();

		// Array input
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tArr[i][j] = sc.nextInt();
				if(tArr[i][j] != -1){
					if (tArr[i][j] == 1)
						queueList.add(new int[] { i, j });
					zeroCnt++;
				}
			}
		}

		// BFS
		if (queueList.size() == 0) {
			System.out.println(answer);
			return;
		}

		int cnt = 0;
		while (queueList.size() != 0) {
			answer++;
			for (int[] arr : queueList) {
				for (int i = 0; i < 4; i++) {
					int posX = arr[0] + dirX[i];
					int posY = arr[1] + dirY[i];
					if (posX < 0 || posY < 0 || posX >= M || posY >= N || tArr[posX][posY] == 1
							|| tArr[posX][posY] == -1)
						continue;
					tArr[posX][posY] = 1;
					nextList.add(new int[] { posX, posY });
				}
				cnt++;
			}

			queueList.clear();
			queueList.addAll(nextList);
			nextList.clear();

		}
		if (cnt == zeroCnt) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}

	}

}
/*
 * 6 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
 */