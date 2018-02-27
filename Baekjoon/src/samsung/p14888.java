package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
6
1 2 3 4 5 6
2 1 1 1

54
-24
*/

public class p14888 {

	static int N;
	static int max = -1000000000;
	static int min = 1000000000;
	static int[] opArr;
	static int[] nArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nArr = new int[N];
		int[] yArr = new int[4];
		int ySum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			nArr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			yArr[i] = Integer.parseInt(st.nextToken());
			ySum += yArr[i];
		}
		opArr = new int[ySum];
		int cnt = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < yArr[i]; j++){
				opArr[cnt] = i;
				cnt++;
			}

		calcAnswer(new boolean[ySum], nArr[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	public static void calcAnswer(boolean[] visit, int res, int len) {
		if (len == N) {
			min = (res < min) ? res : min;
			max = (res > max) ? res : max;
			return;
		}
		//0 0 1 2 3
		for (int i = 0; i < opArr.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				switch (opArr[i]) {
				case 0:
					calcAnswer(visit, res + nArr[len], len + 1);
					break;
				case 1:
					calcAnswer(visit, res - nArr[len], len + 1);
					break;
				case 2:
					calcAnswer(visit, res * nArr[len], len + 1);
					break;
				case 3:
					calcAnswer(visit, res / nArr[len], len + 1);
					break;
				}
				visit[i] = false;
			}
		}
	}

}