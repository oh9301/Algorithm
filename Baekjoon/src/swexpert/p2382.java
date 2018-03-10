package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Cell{
	int row;
	int col;
	int mount;
	int direction;
	
	public Cell(int row, int col, int mount, int direction) {
		this.row = row;
		this.col = col;
		this.mount = mount;
		this.direction = direction;
	}
}

public class p2382 {
	
	static int answer;
	static int N, M, K;
	static ArrayList<Cell> cList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cList = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				cList.add(new Cell(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			sumCellAmount(M);
			System.out.println("#"+(t+1)+" "+answer);
		}
	}	
	
	public static void sumCellAmount(int availCnt){
		int[][] visit;
		int[][] max;
		int[][] dir;
		for (int t = 0; t < M; t++) {
			max = new int[N][N];
			visit = new int[N][N];
			dir = new int[N][N];
			ArrayList<Cell> nextList = new ArrayList<>(); 
			for (Cell c : cList) {
				if(c.direction == 1)	c.row = c.row - 1;
				else if(c.direction == 2)	c.row = c.row + 1;
				else if(c.direction == 3)	c.col = c.col - 1;
				else	c.col = c.col + 1;
				if(visit[c.row][c.col] == 0){
					if(c.row == 0 || c.col == 0 || c.row == N-1 || c.col == N-1){
						visit[c.row][c.col] = c.mount/2;
						dir[c.row][c.col] = (c.direction % 2 == 1) ? c.direction + 1 :  c.direction - 1;
					} else{
						visit[c.row][c.col] = c.mount;
						dir[c.row][c.col] = c.direction;
					}
					max[c.row][c.col] = c.mount;
				}
				else{
					if(max[c.row][c.col] < c.mount){
						max[c.row][c.col] = c.mount;
						dir[c.row][c.col] = c.direction;
					}
					visit[c.row][c.col] += c.mount;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					if(visit[i][j] != 0)
						nextList.add(new Cell(i, j, visit[i][j], dir[i][j]));
			}
			
			cList.clear();
			cList.addAll(nextList);
			nextList.clear();
		}
		
		for (Cell res : cList) {
			answer += res.mount;
		}
	}

}
