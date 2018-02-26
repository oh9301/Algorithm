import java.util.ArrayList;
import java.util.Scanner;

public class p7576_2 {

	static int answer;
	static int M;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int zeroCnt = 0;
		int[][] tArr = new int[M][N];
		int[][] visitArr = new int[M][N];
		int[] dirX = { 1, -1, 0, 0 };
		int[] dirY = { 0, 0, 1, -1 };
		ArrayList<int[]> queueList = new ArrayList<int[]>();

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
		int curX = 0;
		int curY = 0;
		int cnt = 0;

		while (queueList.size() != 0) {

			curX = queueList.get(0)[0];
			curY = queueList.get(0)[1];
			queueList.remove(0);
			
			if(visitArr[curX][curY] == 0){
				
				visitArr[curX][curY] = 1;
				
				for (int i = 0; i < 4; i++) {
					int posX = curX + dirX[i];
					int posY = curY + dirY[i];
					if(posX < 0 || posY < 0 || posX >= M || posY >= N 
							|| tArr[posX][posY] == -1 || tArr[posX][posY] == 1)
						continue;
					if(visitArr[posX][posY] == 0 && tArr[posX][posY] == 0){
						tArr[posX][posY] = tArr[curX][curY] + 1;
						queueList.add(new int[]{posX, posY});
					}
				}
				cnt++;
			}
			
			if(cnt == zeroCnt){
				System.out.println(tArr[curX][curY] - 1);
				return;
			}

		}

		System.out.println(-1);

	}

}
/*
 * 6 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
 */