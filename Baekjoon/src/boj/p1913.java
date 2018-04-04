package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class LandSnail{
	int i;
	int j;
	int direction;
	int value;
	//direction
	// 1 : 동 / 2 : 남 / 3 : 서 / 0 : 북
	
	public LandSnail(int i, int j, int direction, int value) {
		this.i = i;
		this.j = j;
		this.direction = direction;
		this.value = value;
	}
	
}

public class p1913 {
	
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, 1, 0, -1};
	static int ansX, ansY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 달팽이 배열 크기 입력 : N
		int N = Integer.parseInt(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int[][] res = BFS(new int[N][N], N, target);
		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				answer.append(res[i][j] + " ");
			answer.append("\n");
		}
		answer.append(ansX + " " + ansY);
		System.out.println(answer);
	}

	public static int[][] BFS(int[][] map, int len, int target){
		Queue<LandSnail> queue = new LinkedList<>();
		queue.add(new LandSnail(0, 0, 2, len*len));
		map[0][0] = len*len;
		while(!queue.isEmpty()){
			LandSnail elem = queue.poll();
			map[elem.i][elem.j] = elem.value;
			if(map[elem.i][elem.j] == target){
				ansX = elem.i + 1;
				ansY = elem.j + 1;
			}
			if(map[elem.i][elem.j] == 1)
				break;
			int ni = elem.i + posi[elem.direction];
			int nj = elem.j + posj[elem.direction];
			// 방향 전환 해야 하는 경우. (끝이거나 진행하는 방향에 수가 있는경우 (0이 아닌 경우))
			if(ni < 0 || nj < 0 || ni >= len || nj >= len || map[ni][nj] != 0){
				ni = elem.i + posi[(elem.direction + 3)%4];
				nj = elem.j + posj[(elem.direction + 3)%4];
				queue.add(new LandSnail(ni, nj, (elem.direction + 3)%4 , elem.value - 1));
			}else{
				queue.add(new LandSnail(ni, nj, elem.direction , elem.value - 1));
			}
		}
		return map;
	}
}

