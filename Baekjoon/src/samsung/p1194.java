package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class MinSik{
	int i;
	int j;
	int cnt;
	String key;
	
	public MinSik(int i, int j, int cnt, String key) {
		super();
		this.i = i;
		this.j = j;
		this.cnt = cnt;
		this.key = key;
	}
}

public class p1194 {
	
	static int N, M;
	static char[][] map;
	static int answer = -1;
	static Map<String, boolean[][]> check;
	static int[] posi = {-1, 0, 1, 0};
	static int[] posj = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int st_i = 0;	int st_j = 0;
		ArrayList<MinSik> endList = new ArrayList<>();
		map = new char[N][M];
		check = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String inp = br.readLine();
			for (int j = 0; j < M; j++){
				map[i][j] = inp.charAt(j);
				if(map[i][j] == '0'){
					st_i = i;
					st_j = j;
				} else if(map[i][j] == '1'){
					endList.add(new MinSik(i, j, 0, null));
				}
			}
		}
		BFS(st_i, st_j, endList);
		System.out.println(answer);
	}
	
	public static void BFS(int start_i, int start_j, ArrayList<MinSik> edlist){
		Queue<MinSik> queue = new LinkedList<>();
		queue.add(new MinSik(start_i, start_j, 0, "000000"));
		check.put("000000", new boolean[N][M]);
		check.get("000000")[start_i][start_j] = true;
		while(!queue.isEmpty()){
			MinSik mp = queue.poll();
			for (MinSik e : edlist) {
				if(e.i == mp.i && e.j == mp.j){
					answer = mp.cnt;
					return;
				}
			}
			for (int k = 0; k < 4; k++) {
				int ni = mp.i + posi[k];
				int nj = mp.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == '#')
					continue;
				if(map[ni][nj] >= 'a' && map[ni][nj] <= 'f'){
					String newkey = convertKey(mp.key, map[ni][nj]);
					if(check.get(newkey) == null)
						check.put(newkey, new boolean[N][M]);
					if(!check.get(newkey)[ni][nj]){
						check.get(newkey)[ni][nj] = true;
						queue.add(new MinSik(ni, nj, mp.cnt + 1, newkey));
					}
				}
				else if(map[ni][nj] >= 'A' && map[ni][nj] <= 'F'){
					if(mp.key.charAt(map[ni][nj] - 'A') == '1'){
						if(check.get(mp.key) == null)
							check.put(mp.key, new boolean[N][M]);
						if(!check.get(mp.key)[ni][nj]){
							check.get(mp.key)[ni][nj] = true;
							queue.add(new MinSik(ni, nj, mp.cnt + 1, mp.key));
						}
					}
				}
				else{
					if(check.get(mp.key) == null)
						check.put(mp.key, new boolean[N][M]);
					if(!check.get(mp.key)[ni][nj]){
						check.get(mp.key)[ni][nj] = true;
						queue.add(new MinSik(ni, nj, mp.cnt + 1, mp.key));
					}
				}
			}
		}
	}
	
	public static String convertKey(String keylist, char key){
		char[] keyArr = keylist.toCharArray();
		keyArr[key-'a'] = '1';
		return new String(keyArr);
	}

}
