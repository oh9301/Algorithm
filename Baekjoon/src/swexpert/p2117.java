package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 모의 SW 역량테스트 [홈 방범 서비스] 
public class p2117 {
	
	static int N, M;
	static int[][] map;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			calcMaxHome();
			System.out.println("#"+(t+1)+" "+answer);
		}
	}
	
	public static void calcMaxHome(){
		for (int k = 0; k < N+1; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					answer = Math.max(answer, countHome(i, j, k));
			}
		}
	}

	public static int countHome(int row, int col, int k){
		int cnt = 0;
		for (int i = -k; i <= k; i++) {
			int absI = Math.abs(i);
			if(row + i < 0 || row + i >= N)
				continue;
			for (int j = absI - k; j <= -absI + k; j++) {
				if(col + j < 0 || col + j >= N)
					continue;
				cnt += map[row+i][col+j];
			}
		}
		if(M*cnt >= k*k + (k+1)*(k+1))
			return cnt;
		return -1;
	}
}
