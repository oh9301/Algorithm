package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p14499 {
	
	static int N;
	static int M;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int [][] map = new int[N][M];
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [] dice = new int[6];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int tmp = 0;
		for (int i = 0; i < K; i++) {
			int input = Integer.parseInt(st.nextToken());
			if(input == 4){
				if(x+1 >= N)
					continue;
				x += 1;
				tmp = dice[0];
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = tmp;
			} else if(input == 3){
				if(x-1 < 0)
					continue;
				x -= 1;
				tmp = dice[0];
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = tmp;
			} else if(input == 2){
				if(y-1 < 0)
					continue;
				y -= 1;
				tmp = dice[0];
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
			} else{
				if(y+1 >= M)
					continue;
				y += 1;
				tmp = dice[0];
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = tmp;
			}
			
			if(map[x][y] == 0)
				map[x][y] = dice[5];
			else{
				dice[5] = map[x][y];
				map[x][y] = 0;
			}
			System.out.println(dice[0]);
		}
	}
}
