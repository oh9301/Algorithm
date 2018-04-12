package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class MP{
	int i;
	int j;
	
	public MP(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
}

public class p1227 {
	
	static int si, sj, ei, ej;
	static int answer;
	static char[][] map;
	static boolean[][] visited;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = 0;
			int T = Integer.parseInt(br.readLine());
			map = new char[100][100];
			visited = new boolean[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = input.charAt(j);
					if(map[i][j] == '2'){
						si = i;
						sj = j;
					}else if(map[i][j] == '3'){
						ei = i;
						ej = j;
					}
				}
			}
			bfs();
			System.out.println("#"+T+" "+answer);
		}
	}
	
	public static void bfs(){
		Queue<MP> queue = new LinkedList<>();
		queue.add(new MP(si, sj));
		while(!queue.isEmpty()){
			MP p = queue.poll();
			if(p.i == ei && p.j == ej){
				answer = 1;
				return;
			}
			for (int k = 0; k < 4; k++) {
				int ni = p.i + posi[k];
				int nj = p.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= 100 || nj >= 100)
					continue;
				if(map[ni][nj] != '1'){
					map[ni][nj] = '1';
					queue.add(new MP(ni, nj));
				}
			}
		}
	}
}
