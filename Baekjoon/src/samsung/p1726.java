package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class FRobot{
	int i;
	int j;
	int dir;
	int count;
	
	public FRobot(int i, int j, int dir, int count) {
		this.i = i;
		this.j = j;
		this.dir = dir;
		this.count = count;
	}
	
}

public class p1726 {
	
	static int M, N, answer;
	static int[][] map;
	static boolean[][][] visited;
	static int[] posX = {-1, 0, 1, 0};
	static int[] posY = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N][4];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		FRobot st_robot = new FRobot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())-1, 0);
		st = new StringTokenizer(br.readLine());
		FRobot ed_robot = new FRobot(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())-1, 0);
		
		moveRobot(st_robot, ed_robot);
		System.out.println(answer);
	}
	
	public static void moveRobot(FRobot st_robot, FRobot ed_robot){
		Queue<FRobot> queue = new LinkedList<>();
		queue.add(st_robot);
		visited[st_robot.i][st_robot.j][st_robot.dir] = true;
		while(!queue.isEmpty()){
			FRobot fr = queue.poll();
			if(fr.i == ed_robot.i && fr.j == ed_robot.j && fr.dir == ed_robot.dir){
				answer = fr.count;
				return;
			}
			for (int k = 3; k >= 1; k--) {
				check(queue, fr, k);
			}
			if(!visited[fr.i][fr.j][leftRotate(fr.dir)]){
				visited[fr.i][fr.j][leftRotate(fr.dir)] = true;
				queue.add(new FRobot(fr.i, fr.j, leftRotate(fr.dir), fr.count+1));
			}
			if(!visited[fr.i][fr.j][rightRotate(fr.dir)]){
				visited[fr.i][fr.j][rightRotate(fr.dir)] = true;
				queue.add(new FRobot(fr.i, fr.j, rightRotate(fr.dir), fr.count+1));
			}
		}
	}
	
	public static int leftRotate(int dir){
		int resDir = 0;
		if(dir == 0)	resDir = 3;
		else if(dir == 1)	resDir = 2;
		else if(dir == 2)	resDir = 0;
		else	resDir = 1;
		return resDir;
	}
	
	public static int rightRotate(int dir){
		int resDir = 0;
		if(dir == 0)	resDir = 2;
		else if(dir == 1)	resDir = 3;
		else if(dir == 2)	resDir = 1;
		else	resDir = 0;
		return resDir;
	}
	
	public static int getDirIndex(int dir){
		int index = 0;
		if(dir == 0)	index = 3;
		else if(dir == 1)	index = 1;
		else if(dir == 2)	index = 2;
		else	index = 0;
		return index;
	}
	
	public static void check(Queue<FRobot> queue, FRobot fr, int k){
		int index = getDirIndex(fr.dir);
		int sum = 0;
		int ni = fr.i;
		int nj = fr.j;
		for (int i = 0; i < k; i++) {
			ni += posX[index];
			nj += posY[index];
			if(ni < 0 || nj < 0 || ni >= M || nj >= N)
				return;
			sum += map[ni][nj];
			if(sum > 0)
				return;
		}
		if(!visited[ni][nj][fr.dir]){
			visited[ni][nj][fr.dir] = true;
			queue.add(new FRobot(ni, nj, fr.dir, fr.count+1));
		}
	}

}

//방향은 동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4로 주어진다. 출발지점에서 도착지점까지는 항상 이동이 가능하다.

/*
5 6
0 0 0 0 0 0
0 1 1 0 1 0
0 1 0 0 0 0
0 0 1 1 1 0
1 0 0 0 0 0
4 2 3
2 4 1
*/