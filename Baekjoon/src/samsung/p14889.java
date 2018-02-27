package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 
축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.

BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 
능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. 
Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.

축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다.
위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.

첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최소값을 출력한다.

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
	
	// 개선 전 방법
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
