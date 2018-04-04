package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tester{
	int i;
	int j;
	int dir;	// ºÏ¼­³²µ¿ 0123
	int memory;
	
	public Tester(int i, int j, int dir, int memory) {
		this.i = i;
		this.j = j;
		this.dir = dir;
		this.memory = memory;
	}
	
}

public class p1824 {
	
	static int R, C;
	static char[][] map;
	static boolean[][][][] visited;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visited = new boolean[R][C][4][16];
			for (int i = 0; i < R; i++) {
				String inp = br.readLine();
				for (int j = 0; j < C; j++)
					map[i][j] = inp.charAt(j);
			}
			System.out.println("#"+t+" "+validateSSPC());
		}
	}
	
	public static String validateSSPC(){
		Queue<Tester> queue = new LinkedList<>();
		queue.add(new Tester(0, 0, 3, 0));
		while(!queue.isEmpty()){
			Tester t = queue.poll();
			int flag = execCommand(t, map[t.i][t.j]);
			if(flag == -1)
				return "YES";
			else if(flag == 1){
				for (int k = 0; k < 4; k++) {
					int ni = t.i + posi[k];
					int nj = t.j + posj[k];
					if(ni < 0 || ni >= R)
						ni = (ni + R) % R;
					if(nj < 0 || nj >= C)
						nj = (nj + C) % C;
					if(!visited[ni][nj][k][t.memory]){
						visited[ni][nj][k][t.memory] = true;
						queue.add(new Tester(ni, nj, k, t.memory));
					}
				}
			}else{
				int ni = t.i + posi[t.dir];
				int nj = t.j + posj[t.dir];
				if(ni < 0 || ni >= R)
					ni = (ni + R) % R;
				if(nj < 0 || nj >= C)
					nj = (nj + C) % C;
				if(!visited[ni][nj][t.dir][t.memory]){
					visited[ni][nj][t.dir][t.memory] = true;
					queue.add(new Tester(ni, nj, t.dir, t.memory));
				}
			}
		}
		return "NO";
	}
	
	public static int execCommand(Tester e, char c){
		int flag = 0;
		if(c == '<')
			e.dir = 1;
		else if(c == '>')
			e.dir = 3;
		else if(c == '^')
			e.dir = 0;
		else if(c == 'v')
			e.dir = 2;
		else if(c == '_'){
			if(e.memory == 0)
				e.dir = 3;
			else
				e.dir = 1;
		}
		else if(c == '|'){
			if(e.memory == 0)
				e.dir = 2;
			else
				e.dir = 0;
		}
		else if(c == '?')
			flag = 1;
		else if(c == '@')
			flag = -1;
		else if(c >= '0' && c <= '9')
			e.memory = c - '0';
		else if(c == '+')
			e.memory = (e.memory + 1) % 16;
		else if(c == '-')
			e.memory = (e.memory + 15) % 16;
		
		return flag;
	}
}
