package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1210 {
	
	static char[][] map;
	static boolean[][] visited;
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 0;
		while(t < 10){
			t = Integer.parseInt(br.readLine());
			map = new char[100][100];
			visited = new boolean[100][100];
			int starti = 0;
			int startj = 0;
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++){
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j] == '2'){
						starti = i;
						startj = j;
					}
				}
			}
			answer = search(starti, startj);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static int search(int i, int j){
		// 0 : аб, 1 : ©Л, 2 : ю╖
		int dir = 2;
		while(i != 0){
			if(dir == 2){
				if(j + 1 < 100 && map[i][j+1] == '1'){
					dir = 1;
					j += 1;
				}
				else if(j - 1 >= 0 && map[i][j-1] == '1'){
					dir = 0;
					j -= 1;
				} else{
					i -= 1;
				}
			} else if(dir == 1){
				if(j+1 >= 100 || map[i][j+1] == '0'){
					dir = 2;
					i -= 1;
				} else{
					j += 1;
				}
			} else{
				if(j-1 < 0 || map[i][j-1] == '0'){
					dir = 2;
					i -= 1;
				} else{
					j -= 1;
				}
			}
		}
		return j;
	}

}
