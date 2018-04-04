package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Prisoner {
	int i;
	int j;

	public Prisoner(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class p9376 {

	static final int INF = 10001;
	static int h, w, answer;
	static int[][] map;
	static int[] posi = { -1, 0, 1, 0 };
	static int[] posj = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = INF;
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken()) + 2;
			w = Integer.parseInt(st.nextToken()) + 2;
			map = new int[h][w];
			ArrayList<Prisoner> plist = new ArrayList<>();

			for (int i = 1; i < h - 1; i++) {
				String inp = br.readLine();
				for (int j = 1; j < w - 1; j++) {
					char c = inp.charAt(j-1);
					if (c == '.')
						map[i][j] = 0;
					else if (c == '#')
						map[i][j] = 2;
					else if (c == '*')
						map[i][j] = -1;
					else if (c == '$'){
						plist.add(new Prisoner(i, j));
						map[i][j] = 1;
					}
				}
			}
			
			int[][] res1 = searchDistance(new Prisoner(0, 0));
			int[][] res2 = searchDistance(plist.get(0));
			int[][] res3 = searchDistance(plist.get(1));
			
			int tmp = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					tmp = res1[i][j] + res2[i][j] + res3[i][j];
					if(tmp < 0)
						continue;
					if(map[i][j] == 2)
						tmp -= 2;
					answer = Math.min(answer, tmp);
				}
			}
			System.out.println(answer);
		}

	}
	
	public static int[][] searchDistance(Prisoner pr){
		int[][] dMap = new int[h][w];
		for (int i = 0; i < h; i++)
			Arrays.fill(dMap[i], -1);
		Queue<Prisoner> queue = new LinkedList<>();
		queue.add(pr);
		dMap[pr.i][pr.j] = 0;
		while(!queue.isEmpty()){
			Prisoner p = queue.poll();
			for (int k = 0; k < 4; k++) {
				int ni = p.i + posi[k];
				int nj = p.j + posj[k];
				if(ni < 0 || nj < 0 || ni >= h || nj >= w || map[ni][nj] == -1)
					continue;
				if(map[ni][nj] == 0 || map[ni][nj] == 1){
					if(dMap[ni][nj] == -1 || dMap[ni][nj] > dMap[p.i][p.j]){
						dMap[ni][nj] = dMap[p.i][p.j];
						queue.add(new Prisoner(ni, nj));
					}
				}else if(map[ni][nj] == 2){
					if(dMap[ni][nj] == -1 || dMap[ni][nj] > dMap[p.i][p.j] + 1){
						dMap[ni][nj] = dMap[p.i][p.j] + 1;
						queue.add(new Prisoner(ni, nj));
					}
				}
			}
		}
		return dMap;
	}

}
