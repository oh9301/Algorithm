/*
 * 입력 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H 가 주어진다. M은 상자의 가로 칸의 수,
 * N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장
 * 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가
 * 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은
 * 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H 번 반복하여 주어진다.
 * 
 * 출력 여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는
 * 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1 을 출력해야 한다.
 * 
 * 5 3 1 0 -1 0 0 0 -1 -1 0 1 1 0 0 0 1 1
 * 6 4 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1
 * 8
 * -1
 */

import java.util.ArrayList;
import java.util.Scanner;

class P {
	int x;
	int y;
	int z;

	public P(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class p7569 {

	static int answer;
	static int M;
	static int N;
	static int H;
	static ArrayList<P> qList;
	static ArrayList<P> qtmpList;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		qList = new ArrayList<>();
		qtmpList = new ArrayList<>();
		int[][][] tArr = new int[H][N][M];
		int tNum = M * N * H;
		answer = -1;

		for (int i = 0; i < H; i++)
			for (int j = 0; j < N; j++)
				for (int k = 0; k < M; k++) {
					tArr[i][j][k] = sc.nextInt();
					if (tArr[i][j][k] == -1)
						tNum -= 1;
					else if (tArr[i][j][k] == 1) {
						qList.add(new P(i, j, k));
					}
				}
		if(qList.isEmpty()){
			System.out.println(0);
			return;
		}
		
		int[] disX = { -1, 1, 0, 0, 0, 0 };
		int[] disY = { 0, 0, -1, 1, 0, 0 };
		int[] disZ = { 0, 0, 0, 0, -1, 1 };
		
		while (!qList.isEmpty()) {
			for (P cur : qList) {
				for (int i = 0; i < 6; i++) {
					int nX = cur.x + disX[i];
					int nY = cur.y + disY[i];
					int nZ = cur.z + disZ[i];
					
					if (nX < 0 || nY < 0 || nZ < 0 || nX >= H || nY >= N || nZ >= M || tArr[nX][nY][nZ] != 0)
						continue;
					tArr[nX][nY][nZ] = 1;
					qtmpList.add(new P(nX, nY, nZ));
				}
				tNum--;
			}
			qList.clear();
			qList.addAll(qtmpList);
			qtmpList.clear();
			answer++;
		}
		if(tNum != 0)
			answer = -1;
		
		System.out.println(answer);
	}

}