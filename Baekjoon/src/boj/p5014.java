package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p5014 {
	
	static int F, S, G, U, D;
	static int answer;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		answer = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visit = new boolean[F+1];
		
		DFS(0, S);
		if(answer == -1)
			System.out.println("use the stairs");
		else
			System.out.println(answer);
	}
	
	public static void DFS(int cnt, int floor){
		if(floor < 1 || floor > F || visit[floor])
			return;
		if(floor == G){
			if(answer == -1)
				answer = cnt;
			else
				answer = Math.min(cnt, answer);
			return;
		}
		visit[floor] = true;
		DFS(cnt + 1, floor + U);
		DFS(cnt + 1, floor - D);
	}

}
