package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952 {

	static int answer;
	static int[] pArr;
	static int[] monthArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pArr = new int[4];
			for (int i = 0; i < 4; i++)
				pArr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			monthArr = new int[12];
			for (int i = 0; i < 12; i++)
				monthArr[i] = Integer.parseInt(st.nextToken());

			answer = pArr[3];
			execDFS(0, new int[14], 0);
			System.out.println("#" + (t + 1) + " " + answer);
		}
	}
	
	public static int sumVisit(int[] visit){
		int sum = 0;
		for (int i = 0; i < 12; i++) {
			sum += visit[i];
		}
		return sum;
	}

	public static void execDFS(int index, int[] visit, int sum) {
		if (sumVisit(visit) == 12) {
			answer = Math.min(sum, answer);
		}
		for (int i = index; i < monthArr.length; i++) {
			if (visit[i] + visit[i+1] + visit[i+2] == 0) {
				visit[i] = 1; visit[i+1] = 1; visit[i+2] = 1;
				execDFS(i + 3, visit, sum + pArr[2]);
				visit[i] = 0; visit[i+1] = 0; visit[i+2] = 0;
			}
			if (visit[i] == 0) {
				visit[i] = 1;
				if (pArr[1] < pArr[0] * monthArr[i])
					execDFS(i + 1, visit, sum + pArr[1]);
				else
					execDFS(i + 1, visit, sum + (pArr[0] * monthArr[i]));
				visit[i] = 0;
			}
		}
	}
}
