package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14503 {
	
	static int N;
	static int M;
	static int[][] map;
	static int answer;
	static int[] posR = {-1, 0, 1, 0};
	static int[] posC = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		// 0 : ºÏ / 1 : µ¿ / 2 : ³² / 3 : ¼­ 
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		cleaningArea(r, c, d);
		System.out.println(answer);
		
	}
	
	public static void cleaningArea(int r, int c, int direction){
		boolean pathFlag = true;
		if(map[r][c] == 0){
			map[r][c] = -1;
			answer++;
		}
		for (int i = 0; i < 4; i++) {
			direction -= 1;
			if(direction < 0)
				direction += 4;
			int nR = r + posR[direction];
			int nC = c + posC[direction];
			if(nR < 0 || nC < 0 || nR >= N || nC >= M || map[nR][nC] == 1 || map[nR][nC] == -1)
				continue;
			cleaningArea(nR, nC, direction);
			pathFlag = false;
			break;
		}
		
		if(pathFlag){
			int preR = r + posR[(direction+2)%4];
			int preC = c + posC[(direction+2)%4];
			if(preR < 0 || preC < 0 || preR >= N || preC >= M || map[preR][preC] == 1)
				return;
			cleaningArea(preR, preC, direction);
		}
	}

}
