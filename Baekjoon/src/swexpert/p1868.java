package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p1868 {

	static char[][] map;
	static boolean[][] visited;
	static int N, answer;
	static final int INF = 90001;
	static int[] posi = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] posj = {-1, 0, 1, -1, 1, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++)
					map[i][j] = input.charAt(j);
			}
			prep();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == '0' && !visited[i][j]){
						visited[i][j] = true;
						DFS(i, j);
						answer++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j])
						answer++;
				}
			}
			
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void prep(){
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '*')
					visited[i][j] = true;
				else{
					int count = 0;
					for (int m = i-1; m <= i+1; m++) {
						if(m < 0 || m >= N)
							continue;
						for (int n = j-1; n <= j+1; n++) {
							if(n < 0 || n >= N)
								continue;
							if(map[m][n] == '*')
								count++;
						}
					}
					map[i][j] = (char)(count + '0');
				}
			}
		}
	}
	
	public static void DFS(int i, int j){
		for (int k = 0; k < 8; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= N || nj >= N || visited[ni][nj])
				continue;
			visited[ni][nj] = true;
			if(map[ni][nj] == '0')
				DFS(ni, nj);
		}
	}
}
