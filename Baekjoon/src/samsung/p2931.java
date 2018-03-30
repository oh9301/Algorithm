package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class PPoint{
	int i;
	int j;
	
	public PPoint(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class p2931 {
	
	static int R, C;
	static String answer;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] curtodir;
	static boolean[][] dirtonext;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int mi = 0, mj = 0, zi = 0, zj = 0; 
		for (int i = 0; i < R; i++) {
			String inp = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = inp.charAt(j);
				if(c == '.')
					map[i][j] = 0;
				else if(c == 'M'){
					mi = i;
					mj = j;
					map[i][j] = 8;
				} else if(c == 'Z'){
					zi = i;
					zj = j;
					map[i][j] = 9;
				} else if(c == '|')
					map[i][j] = 5;
				else if(c == '-')
					map[i][j] = 6;
				else if(c == '+')
					map[i][j] = 7;
				else
					map[i][j] = c - '0';
			}
		}
		init();
		boolean chkM = dirCheck(mi, mj);
		boolean chkZ = dirCheck(zi, zj);
		if(chkM && chkZ){
			BFS(mi, mj, chkM, chkZ, 8, 9);
		} else if(chkM){
			BFS(mi, mj, chkM, chkZ, 8, 9);
		} else if(chkZ){
			BFS(zi, zj, chkM, chkZ, 9, 8);
		} else{
			if(mi == zi)
				answer = mi + " " + ((mj + zj) / 2) + " " + "-";
			else if(mj == zj)
				answer = ((mi + zi) / 2) + " " + mj + " " + "|";
			System.out.println(answer);
			return;
		}
		System.out.println(answer);
	}
	
	public static void BFS(int sti, int stj, boolean nnM, boolean nnZ, int stNum, int edNum){
		visited = new boolean[R][C];
		Queue<PPoint> queue = new LinkedList<>();
		queue.add(new PPoint(sti, stj));
		visited[sti][stj] = true;
		while(!queue.isEmpty()){
			PPoint p = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ni = p.i + posi[k];
				int nj = p.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= R || nj >= C || visited[ni][nj])
					continue;
				if(map[ni][nj] == edNum){
					visited[ni][nj] = true;
					continue;
				}
				if(map[p.i][p.j] == stNum){
					if(dirtonext[k][map[ni][nj]]){
						visited[ni][nj] = true;
						queue.add(new PPoint(ni, nj));
					}
					continue;
				}
				if(curtodir[map[p.i][p.j]][k]){
					if(dirtonext[k][map[ni][nj]]){
						visited[ni][nj] = true;
						queue.add(new PPoint(ni, nj));
					}
					else{
						answer = getAnswer(ni, nj, nnM, nnZ);
						return;
					}
				}
			}
		}
	}
	
	public static boolean dirCheck(int i, int j){
		boolean flag = false;
		for (int k = 0; k < 4; k++) {
			int ni = i + posi[k];
			int nj = j + posj[k];
			if(ni < 0 || nj < 0 || ni >= R || nj >= C || !dirtonext[k][map[ni][nj]]){
				continue;
			}
			flag = true;
		}
		return flag;
	}
	
	public static String getAnswer(int ni, int nj, boolean nnM, boolean nnZ){
		boolean[] arr = new boolean[4];
		String answer = (ni+1) + " " + (nj+1) + " ";
		if(nnM && nnZ){
			for (int k = 0; k < 4; k++) {
				int i = ni + posi[k];
				int j = nj + posj[k];
				if(i >= 0 && j >= 0 && i < R && j < C && dirtonext[k][map[i][j]]){
					arr[k] = true;
				}
			}
		} else if(nnM){
			for (int k = 0; k < 4; k++) {
				int i = ni + posi[k];
				int j = nj + posj[k];
				if(i >= 0 && j >= 0 && i < R && j < C){
					if(dirtonext[k][map[i][j]])
						arr[k] = true;
					else if(map[i][j] == 9)
						arr[k] = true;
				}
			}
		} else if(nnZ){
			for (int k = 0; k < 4; k++) {
				int i = ni + posi[k];
				int j = nj + posj[k];
				if(i >= 0 && j >= 0 && i < R && j < C){
					if(dirtonext[k][map[i][j]])
						arr[k] = true;
					else if(map[i][j] == 8)
						arr[k] = true;
				}
			}
		}
		for (int i = 1; i < 8; i++) {
			if(getEqualsArray(arr, curtodir[i])){
				if(i == 5)
					answer += "|";
				else if(i == 6)
					answer += "-";
				else if(i == 7)
					answer += "+";
				else
					answer += i; 
			}
		}
		return answer;
	}
	
	public static boolean getEqualsArray(boolean[] arr1, boolean[] arr2){
		boolean flag = true;
		for (int j = 0; j < 4; j++) {
			if(arr1[j] != arr2[j]){
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	public static void init(){
		curtodir = new boolean[8][4];
		dirtonext = new boolean[4][10];
		
		curtodir[1][2] = true;	curtodir[1][3] = true;
		curtodir[2][0] = true;	curtodir[2][3] = true;
		curtodir[3][0] = true;	curtodir[3][1] = true;
		curtodir[4][1] = true;	curtodir[4][2] = true;
		curtodir[5][0] = true;	curtodir[5][2] = true;
		curtodir[6][1] = true;	curtodir[6][3] = true;
		curtodir[7][0] = true;	curtodir[7][1] = true;	curtodir[7][2] = true;	curtodir[7][3] = true;
		
		dirtonext[0][1] = true;	dirtonext[0][4] = true;	dirtonext[0][5] = true;	dirtonext[0][7] = true;
		dirtonext[1][1] = true;	dirtonext[1][2] = true;	dirtonext[1][6] = true;	dirtonext[1][7] = true;
		dirtonext[2][2] = true;	dirtonext[2][3] = true;	dirtonext[2][5] = true;	dirtonext[2][7] = true;
		dirtonext[3][3] = true;	dirtonext[3][4] = true;	dirtonext[3][6] = true;	dirtonext[3][7] = true;
	}
}
/*
3 3
.14
Z.M
23.

3 3
Z.M
|..
2-3
*/
