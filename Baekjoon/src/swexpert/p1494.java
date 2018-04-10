package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Vec {
	int i;
	int j;

	public Vec(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class p1494 {

	static int N;
	static long answer;
	static Vec[] wArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 80000000001L;
			N = Integer.parseInt(br.readLine());
			wArr = new Vec[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				wArr[i] = new Vec(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			DFS(0, 0, new boolean[N]);
			System.out.println("#" + t + " " + answer);
		}
	}

	public static void DFS(int index, int len, boolean[] visited) {
		if (len == N / 2) {
			answer = Math.min(answer, getSum(visited));
			return;
		}
		for (int i = index; i < N; i++) {
			if(!visited[i]){
				visited[i] = true;
				DFS(i+1, len+1, visited);
				visited[i] = false;
			}
		}
	}
	
	public static long getSum(boolean[] visited){
		long sumi = 0;
		long sumj = 0;
		for (int i = 0; i < N; i++) {
			if(visited[i]){
				sumi += wArr[i].i;
				sumj += wArr[i].j;
			} else{
				sumi -= wArr[i].i;
				sumj -= wArr[i].j;
			}
		}
		return sumi*sumi + sumj*sumj;
	}

}
