package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class MP{
	int x;
	int y;
	
	public MP(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

public class p9328 {
	
	static int h, w, answer;
	static char[][] map;
	static Queue<MP> queue;
	static Queue<Character> keyQ;
	static int[] posx = {-1, 0, 1, 0};
	static int[] posy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			queue = new LinkedList<>();
			keyQ = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				String inp = br.readLine();
				for (int j = 0; j < w; j++)
					map[i][j] = inp.charAt(j);
			}
			String keyStr = br.readLine();
			for (int i = 0; i < keyStr.length(); i++)
				keyQ.add(keyStr.charAt(i));
			answer = findDocument();
			System.out.println(answer);
		}
	}
	
	public static void keyRemove(){
		while(!keyQ.isEmpty()){
			char key = Character.toUpperCase(keyQ.poll());
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(key == map[i][j])
						map[i][j] = '.';
				}
			}
		}
	}
	
	public static void findEnterance(){
		//first row
		for (int i = 0; i < w; i++) {
			if(map[0][i] != '*' && (map[0][i] < 'A' || map[0][i] > 'Z'))
				queue.add(new MP(0, i));
		}
		//first col
		for (int i = 1; i < h-1; i++) {
			if(map[i][0] != '*' && (map[i][0] < 'A' || map[i][0] > 'Z'))
				queue.add(new MP(i, 0));
		}
		//last row
		for (int i = 0; i < w; i++) {
			if(map[h-1][i] != '*' && (map[h-1][i] < 'A' || map[h-1][i] > 'Z'))
				queue.add(new MP(h-1, i));
		}
		for (int i = 1; i < h-1; i++) {
			if(map[i][w-1] != '*' && (map[i][w-1] < 'A' || map[i][w-1] > 'Z'))
				queue.add(new MP(i, w-1));
		}
	}
	
	public static int findDocument(){
		int answer = 0;
		while(true){
			keyRemove();
			findEnterance();
			boolean [][] visited = new boolean[h][w];
			while(!queue.isEmpty()){
				MP mp = queue.poll();
				if(visited[mp.x][mp.y])
					continue;
				visited[mp.x][mp.y] = true;
				if(map[mp.x][mp.y] == '$'){
					answer++;
					map[mp.x][mp.y] = '.';
				}
				if(map[mp.x][mp.y] >= 'a' && map[mp.x][mp.y] <= 'z'){
					keyQ.add(map[mp.x][mp.y]);
					map[mp.x][mp.y] = '.';
				}
				for (int t = 0; t < 4; t++) {
					int nx = mp.x + posx[t];
					int ny = mp.y + posy[t];
					if(nx < 0 || ny < 0 || nx >= h || ny >= w || map[nx][ny] == '*' || (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z'))
						continue;
					queue.add(new MP(nx, ny));
				}
			}
			if(keyQ.isEmpty())
				break;
		}
		return answer;
	}
}
