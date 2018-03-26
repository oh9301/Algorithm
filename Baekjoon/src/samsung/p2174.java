package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot{
	int x;
	int y;
	int dir;
	
	public Robot(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
}

class Command{
	int rNum;
	char kind;
	int rep;
	
	public Command(int rNum, char kind, int rep) {
		this.rNum = rNum;
		this.kind = kind;
		this.rep = rep;
	}
	
}

public class p2174 {
	
	static int A, B, N, M;
	static int[][] map;
	static Robot[] rArr;
	static Command[] cArr;
	static int[] posx = {-1, 0, 1, 0};
	static int[] posy = {0, -1, 0, 1};
	static String answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		map = new int[B][A];
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		rArr = new Robot[N];
		cArr = new Command[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int sx = B - Integer.parseInt(st.nextToken());
			char dirC = st.nextToken().charAt(0);
			int dir = 0;
			map[sx][sy] = i+1;
			if(dirC == 'N')	dir = 0;
			else if(dirC == 'W')	dir = 1;
			else if(dirC == 'S')	dir = 2;
			else 	dir = 3;
			rArr[i] = new Robot(sx, sy, dir);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int rbNum = Integer.parseInt(st.nextToken());
			char kind = st.nextToken().charAt(0);
			int rep = Integer.parseInt(st.nextToken());
			cArr[i] = new Command(rbNum, kind, rep);
		}
		
		answer = "OK";
		execCommand();
		System.out.println(answer);
	}

	public static void execCommand(){
		for (int i = 0; i < M; i++) {
			if(moveRobot(cArr[i]))
				return;
		}
	}
	
	public static boolean moveRobot(Command c){
		Robot r = rArr[c.rNum - 1];
		if(c.kind == 'L'){
			for (int i = 0; i < c.rep; i++)
				r.dir = (r.dir+1) % 4;
		}
		else if(c.kind == 'R'){
			for (int i = 0; i < c.rep; i++)
				r.dir = (r.dir+3) % 4;
		} else{
			for (int i = 0; i < c.rep; i++){
				int nx = r.x + posx[r.dir];
				int ny = r.y + posy[r.dir];
				if(nx < 0 || ny < 0 || nx >= B || ny >= A){
					answer = "Robot " + c.rNum + " crashes into the wall";
					return true;
				}
				if(map[nx][ny] != 0){
					answer = "Robot " + c.rNum + " crashes into robot " + map[nx][ny];
					return true;
				}
				map[r.x][r.y] = 0;
				map[nx][ny] = c.rNum;
				r.x = nx;
				r.y = ny;
			}
		}
		return false;
	}
}
/*
5 4
2 2
1 4 E
5 4 W
1 F 3
2 F 1
*/