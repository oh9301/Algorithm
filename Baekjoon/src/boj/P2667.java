package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2667 {
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		ArrayList<Integer> cntList = new ArrayList<>();
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visited[i][j]){
					answer++;
					count = 0;
					search(i, j);
					cntList.add(count);
				}
			}
		}
		System.out.println(answer);
		Collections.sort(cntList);
		for(int elem : cntList)
			System.out.println(elem);
	}

	public static void search(int i, int j){
		visited[i][j] = true;
		count++;
		if(i+1 < N && map[i+1][j] != 0 && !visited[i+1][j])
			search(i + 1, j);
		if(j+1 < N && map[i][j+1] != 0 && !visited[i][j+1])
			search(i, j + 1);
		if(i-1 >= 0 && map[i-1][j] != 0 && !visited[i-1][j])
			search(i - 1, j);
		if(j-1 >= 0 && map[i][j-1] != 0 && !visited[i][j-1])
			search(i, j - 1);
	}
}
