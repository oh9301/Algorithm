package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Core{
	int i;
	int j;
	
	public Core(int i, int j) {
		this.i = i;
		this.j = j;
	}
}

public class p1767 {
	
	static int answer, N;
	static int ansCount;
	static int[][] map;
	static ArrayList<Core> coreList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			answer = N*N;
			ansCount = 0;
			coreList = new ArrayList<>();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
						coreList.add(new Core(i, j));
				}
			}
			DFS(0, 0, 0);
			System.out.println("#"+t+" " + answer);
		}
	}
	
	public static void DFS(int index, int count, int sum){
		if(index == coreList.size()){
			if(ansCount < count){
				answer = sum;
				ansCount = count;
			} else if(ansCount == count && sum < answer){
				answer = sum;
				ansCount = count;
			}
			return;
		}
		Core c = coreList.get(index);
		if(c.i == 0 || c.j == 0 || c.i == N-1 || c.j == N-1)
			DFS(index+1, count, sum);
		else{
			for (int k = 0; k < 4; k++) {
				int res = setEline(k, c.i, c.j);
				if(res == 0)
					continue;
				DFS(index+1, count+1, sum+res);
				reverseMap(k, c.i, c.j);
			}
			DFS(index+1, count, sum);
		}
	}
	
	public static void reverseMap(int flag, int i, int j){
		if(flag == 0){
			for (int s = 0; s < i; s++)
				map[s][j] = 0;
		} else if(flag == 1){
			for (int s = 0; s < j; s++)
				map[i][s] = 0;
		} else if(flag == 2){
			for (int s = i+1; s < N; s++)
				map[s][j] = 0;
		} else if(flag == 3){
			for (int s = j+1; s < N; s++)
				map[i][s] = 0;
		}
	}
	
	public static int setEline(int flag, int i, int j){
		int sum = 0;
		int count = 0;
		if(flag == 0){
			for (int s = 0; s < i; s++)
				sum += map[s][j];
			if(sum == 0){
				count = i;
				for (int s = 0; s < i; s++)
					map[s][j] = 2;
			}
		} else if(flag == 1){
			for (int s = 0; s < j; s++)
				sum += map[i][s];
			if(sum == 0){
				count = j;
				for (int s = 0; s < j; s++)
					map[i][s] = 2;
			}
		} else if(flag == 2){
			for (int s = i+1; s < N; s++)
				sum += map[s][j];
			if(sum == 0){
				count = N - i - 1;
				for (int s = i+1; s < N; s++)
					map[s][j] = 2;
			}
		} else if(flag == 3){
			for (int s = j+1; s < N; s++)
				sum += map[i][s];
			if(sum == 0){
				count = N - j - 1; 
				for (int s = j+1; s < N; s++)
					map[i][s] = 2;
			}
		}
		return count;
	}
}
