package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
������ ��ŸƮ��ũ�� �ٴϴ� ������� �𿩼� �౸�� �غ����� �Ѵ�. �౸�� ���� ���Ŀ� �ϰ� �ǹ� ������ �ƴϴ�. 
�౸�� �ϱ� ���� ���� ����� �� N���̰� �ű��ϰԵ� N�� ¦���̴�. ���� N/2������ �̷���� ��ŸƮ ���� ��ũ ������ ������� ������ �Ѵ�.

BOJ�� ��ϴ� ȸ�� ��� ������� ��ȣ�� 1���� N������ �����߰�, �Ʒ��� ���� �ɷ�ġ�� �����ߴ�. 
�ɷ�ġ Sij�� i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�̴�. ���� �ɷ�ġ�� ���� ���� ��� ���� �ɷ�ġ Sij�� ���̴�. 
Sij�� Sji�� �ٸ� ���� ������, i�� ����� j�� ����� ���� ���� ������ ��, ���� �������� �ɷ�ġ�� Sij�� Sji�̴�.

�౸�� ����ְ� �ϱ� ���ؼ� ��ŸƮ ���� �ɷ�ġ�� ��ũ ���� �ɷ�ġ�� ���̸� �ּҷ� �Ϸ��� �Ѵ�.
���� ������ ���� ��쿡�� 1, 4���� ��ŸƮ ��, 2, 3�� ���� ��ũ ���� ���ϸ� ��ŸƮ ���� �ɷ�ġ�� 6, ��ũ ���� �ɷ�ġ�� 6�� �Ǿ ���̰� 0�� �ǰ� �� ���� �ּ��̴�.

ù° �ٿ� ��ŸƮ ���� ��ũ ���� �ɷ�ġ�� ������ �ּҰ��� ����Ѵ�.

4
0 1 2 3
4 0 5 6
7 1 0 2
3 4 5 0

0

8
0 5 4 5 4 5 4 5
4 0 5 1 2 3 4 5
9 8 0 1 2 3 1 2
9 9 9 0 9 9 9 9
1 1 1 1 0 1 1 1
8 7 6 5 4 0 3 2
9 1 9 1 9 1 0 9
6 5 4 3 2 1 9 0

1
*/

public class p14889 {

	static int N;
	static int[][] ability;
	static ArrayList<Integer> ansList;
	static int answer = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		ansList = new ArrayList<>();
		int sub = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				ability[i][j] = Integer.parseInt(st.nextToken());
		}

		divTeam(-1, new int[N/2], 0, 0);
		//divTeam(-1, new HashSet<Integer>(), 0);
		
		int end = ansList.size() - 1;
		answer = Math.abs(ansList.get(0) - ansList.get(end));
		for (int i = 0; i < ansList.size() / 2; i++) {
			sub = Math.abs(ansList.get(i) - ansList.get(end - i));
			if (sub < answer)
				answer = sub;
		}
		System.out.println(answer);

	}

	// 12 13 14 23 24 34
	// 123 124 125 126 134 135 136 145 146 156 234 235 236 245 246 256 345 346
	// 356 456
	// DFS
	public static void divTeam(int index, int[] narr, int sum, int len) {
		for (int elem = 0 ; elem < len ; elem++) {
			sum += ability[index][narr[elem]];
			sum += ability[narr[elem]][index];
		}
		if (len == N / 2) {
			ansList.add(sum);
			return;
		}
		for (int i = index+1; i < N; i++) {
			narr[len] = i;
			divTeam(i, narr, sum, len+1);
		}
		return;

	}
	
	// ���� �� ���
/*	
	public static void divTeam(int index, HashSet<Integer> nSet, int sum) {
		for (int elem : nSet) {
			if(elem == index)
				continue;
			sum += ability[index][elem];
			sum += ability[elem][index];
		}
		if (nSet.size() == N / 2) {
			ansList.add(sum);
			return;
		}
		for (int i = index+1; i < N; i++) {
			nSet.add(i);
			divTeam(i, nSet, sum);
			nSet.remove(i);
		}
		return;

	}
*/
}
