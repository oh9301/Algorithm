package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1952 {
	
	static int answer;
	static int[] pArr;
	static int[] monthArr;
	static int[] caseArr = {1,2,3};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pArr = new int[4];
			for (int i = 0; i < 4; i++)
				pArr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			monthArr = new int[12];
			for (int i = 0; i < 12; i++)
				monthArr[i] = Integer.parseInt(st.nextToken());
			
			answer = pArr[3];
			execDFS(0, new boolean[12], 0, 0);
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	public static void execDFS(int index, boolean[] visit, int sum, int flag){
		if(flag == 12){
			answer = Math.min(sum, answer);
		}
		for (int i = index; i < monthArr.length; i++) {
			if(!visit[i] && !visit[(i+1)%12] && !visit[(i+2)%12]){
				visit[i] = true; visit[(i+1)%12] = true; visit[(i+2)%12] = true;
				execDFS((i + 3) % 12, visit, sum + pArr[2]*3, flag + 3);
				visit[i] = false; visit[(i+1)%12] = false; visit[(i+2)%12] = false;
			} if(!visit[i]){
				visit[i] = true;
				execDFS((i + 1) % 12, visit, sum + pArr[1], flag + 1);
				execDFS((i + 1) % 12, visit, sum + pArr[0] * monthArr[i], flag + 1);
				visit[i] = false;
			}
		}
	}

}
