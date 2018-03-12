package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [][] rArr;
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			rArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				rArr[i][0] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= M - N; j++) {
					if(i == 0){
						rArr[i][j] = rArr[i][j-1] + 1;
						continue;
					}
					rArr[i][j] = rArr[i-1][j] + rArr[i][j-1]; 
				}
			}
			System.out.println(rArr[N-1][M - N]);
		}
		
	}

}
