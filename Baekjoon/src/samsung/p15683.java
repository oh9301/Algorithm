package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV{
	int i;
	int j;
	
	public CCTV(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
}

public class p15683 {
	
	static int M, N, allCount, area;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<CCTV> cctvlist;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		allCount = M*N;
		map = new int[N][M];
		visited = new boolean[N][M];
		cctvlist = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0 && map[i][j] < 6){
					cctvlist.add(new CCTV(i, j));
					allCount--;
				}else if(map[i][j] == 6)
					allCount--;
			}
		}
		dfs(0, 0);
		System.out.println(allCount - area);
	}
	
	public static void dfs(int index, int count){
		if(index == cctvlist.size()){
			area = Math.max(area, count);
			return;
		}
		CCTV c = cctvlist.get(index);
		if(map[c.i][c.j] == 1){
			for (int d = 0; d < 4; d++) {
				ArrayList<CCTV> vlist = go(c.i, c.j, d, 1);
				dfs(index + 1, count + vlist.size());
				back(vlist);
			}
		}else if(map[c.i][c.j] == 2){
			for (int d = 0; d < 2; d++) {
				ArrayList<CCTV> vlist = go(c.i, c.j, d, 2);
				dfs(index + 1, count + vlist.size());
				back(vlist);
			}
		}else if(map[c.i][c.j] == 3){
			for (int d = 0; d < 4; d++) {
				ArrayList<CCTV> vlist = go(c.i, c.j, d, 3);
				dfs(index + 1, count + vlist.size());
				back(vlist);
			}
		}else if(map[c.i][c.j] == 4){
			for (int d = 0; d < 4; d++) {
				ArrayList<CCTV> vlist = go(c.i, c.j, d, 4);
				dfs(index + 1, count + vlist.size());
				back(vlist);
			}
		} else{
			ArrayList<CCTV> vlist = go(c.i, c.j, 0, 5);
			dfs(index + 1, count + vlist.size());
			back(vlist);
		}
	}
	
	// flag : 방향, cnt : 수행할 횟수.
	public static ArrayList<CCTV> go(int i, int j, int dir, int flag){
		ArrayList<CCTV> reslist = new ArrayList<>();
		if(flag == 1){
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[dir]*m;
				int nj = j + posj[dir]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					return reslist;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
		} else if(flag == 2){
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[dir]*m;
				int nj = j + posj[dir]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					break;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[(dir+2)%4]*m;
				int nj = j + posj[(dir+2)%4]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					return reslist;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
		} else if(flag == 3){
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[dir]*m;
				int nj = j + posj[dir]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					break;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[(dir+1)%4]*m;
				int nj = j + posj[(dir+1)%4]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					return reslist;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
		} else if(flag == 4){
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[dir]*m;
				int nj = j + posj[dir]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					break;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[(dir+1)%4]*m;
				int nj = j + posj[(dir+1)%4]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					break;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
			for (int m = 1; m < M*N; m++) {
				int ni = i + posi[(dir+2)%4]*m;
				int nj = j + posj[(dir+2)%4]*m;
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
					return reslist;
				if(visited[ni][nj] || map[ni][nj] > 0)
					continue;
				visited[ni][nj] = true;
				reslist.add(new CCTV(ni, nj));
			}
		} else{
			for (int k = 0; k < 4; k++) {
				for (int m = 1; m < M*N; m++) {
					int ni = i + posi[k]*m;
					int nj = j + posj[k]*m;
					if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == 6)
						break;
					if(visited[ni][nj] || map[ni][nj] > 0)
						continue;
					visited[ni][nj] = true;
					reslist.add(new CCTV(ni, nj));
				}
			}
			return reslist;
		}
		return reslist;
	}

	public static void back(ArrayList<CCTV> blist){
		for(CCTV c : blist){
			visited[c.i][c.j] = false;
		}
	}
}
