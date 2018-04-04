package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Key{
	int i;
	int j;
	String str;
	
	public Key(int i, int j, String str) {
		this.i = i;
		this.j = j;
		this.str = str;
	}
	
}

public class p2819 {
	
	static char[][] nArr;
	static Map<String, Integer> map;
	static int answer;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			nArr = new char[4][4];
			map = new HashMap<>();
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++)
					nArr[i][j] = st.nextToken().charAt(0);
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					BFS(i, j);
				}
			}
			System.out.println("#"+t+" " + answer);
		}
	}
	
	public static void BFS(int i, int j){
		Queue<Key> queue = new LinkedList<>();
		queue.add(new Key(i, j, nArr[i][j]+""));
		while(!queue.isEmpty()){
			Key k = queue.poll();
			if(k.str.length() == 7){
				if(map.get(k.str) == null){
					map.put(k.str, 1);
					answer++;
				}
				continue;
			}
			for (int t = 0; t < 4; t++) {
				int ni = k.i + posi[t];
				int nj = k.j + posj[t];
				if(ni < 0 || nj < 0 || ni >= 4 || nj >= 4)
					continue;
				queue.add(new Key(ni, nj, k.str+nArr[ni][nj]));
			}
		}
	}
}
