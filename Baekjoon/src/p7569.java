/*
 * �Է� ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �׾ƿ÷����� ������ ���� ��Ÿ���� H �� �־�����. M�� ������ ���� ĭ�� ��,
 * N�� ������ ���� ĭ�� ���� ��Ÿ����. ��, 2 �� M �� 100, 2 �� N �� 100, 1 �� H �� 100 �̴�. ��° �ٺ��ʹ� ����
 * ���� ���ں��� ���� ���� ���ڱ����� ����� �丶����� ������ �־�����. ��, ��° �ٺ��� N���� �ٿ��� �ϳ��� ���ڿ� ��� �丶���� ������
 * �־�����. �� �ٿ��� ���� �����ٿ� ����ִ� �丶����� ���°� M���� ������ �־�����. ���� 1�� ���� �丶��, ���� 0 �� ���� ����
 * �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����. �̷��� N���� ���� H �� �ݺ��Ͽ� �־�����.
 * 
 * ��� �������� �丶�䰡 ��� ���� ������ �ּ� ��ĥ�� �ɸ������� ����ؼ� ����ؾ� �Ѵ�. ����, ����� ������ ��� �丶�䰡 �;��ִ�
 * �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1 �� ����ؾ� �Ѵ�.
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