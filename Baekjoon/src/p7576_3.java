import java.util.ArrayList;
import java.util.Scanner;

class Point{
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class p7576_3 {

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
		int[] dirX = { 1, -1, 0, 0 };
		int[] dirY = { 0, 0, 1, -1 };
		ArrayList<Point> queueList = new ArrayList<Point>();

		// Array input
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				tArr[i][j] = sc.nextInt();
				if(tArr[i][j] != -1){
					if (tArr[i][j] == 1)
						queueList.add(new Point(i,j));
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
		while (!queueList.isEmpty()) {
			Point p = queueList.remove(0);
			for (int i = 0; i < 4; i++) {
				int nextX = p.x + dirX[i];
				int nextY = p.y + dirY[i];
				
				if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N){
					if(tArr[nextX][nextY] == 0){
						queueList.add(new Point(nextX, nextY));
						tArr[nextX][nextY] = tArr[p.x][p.y] + 1;
						if(answer < tArr[nextX][nextY])
							answer = tArr[nextX][nextY];
					}
				}
			}
			cnt++;
		}
		if (cnt == zeroCnt) {
			System.out.println(answer-1);
		} else {
			System.out.println(-1);
		}

	}

}
/*
 * 6 4 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
 */