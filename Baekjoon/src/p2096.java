import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다. 
다음 N개의 줄에는 숫자가 세 개씩 주어진다. 숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.

첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.

3
1 2 3
4 5 6
4 9 0

18 6

5
1 2 3
4 5 6
7 8 9
11 10 12
13 14 0

44 22
*/
public class p2096 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxResult = 0;
		int minResult = 0;
		int[][] dpMax = new int[N][3];
		int[][] dpMin = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				dpMax[i][j] = Integer.parseInt(st.nextToken());
				dpMin[i][j] = dpMax[i][j];
			}
		}
		
		for (int i = 0; i < N-1; i++) {
			int dmax = Math.max(Math.max(dpMax[i][0], dpMax[i][1]), dpMax[i][2]);
			int dmin = Math.min(Math.min(dpMin[i][0], dpMin[i][1]), dpMin[i][2]);
			dpMax[i+1][1] += dmax;
			dpMin[i+1][1] += dmin;
			if(dmax == dpMax[i][1]){
				dpMax[i+1][0] += dmax;
				dpMax[i+1][2] += dmax;
			} else{
				dpMax[i+1][0] += (dmax == dpMax[i][0]) ? dmax : Math.max(dpMax[i][0], dpMax[i][1]);
				dpMax[i+1][2] += (dmax == dpMax[i][2]) ? dmax : Math.max(dpMax[i][1], dpMax[i][2]);
			}
			if(dmin == dpMin[1][1]){
				dpMin[i+1][0] += dmin;
				dpMin[i+1][2] += dmin;
			} else{
				dpMin[i+1][0] += (dmin == dpMin[i][0]) ? dmin : Math.min(dpMin[i][0], dpMin[i][1]);
				dpMin[i+1][2] += (dmin == dpMin[i][2]) ? dmin : Math.min(dpMin[i][1], dpMin[i][2]);
			}
		}
		
		maxResult = Math.max(Math.max(dpMax[N-1][0], dpMax[N-1][1]), dpMax[N-1][2]);
		minResult = Math.min(Math.min(dpMin[N-1][0], dpMin[N-1][1]), dpMin[N-1][2]);
		
		System.out.println(maxResult + " " + minResult);
		
	}

}
