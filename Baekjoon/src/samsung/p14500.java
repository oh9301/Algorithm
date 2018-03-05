package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
4 10
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1
1 2 1 2 1 2 1 2 1 2
2 1 2 1 2 1 2 1 2 1

7
*/
public class p14500 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int [] revY = {1, 1, -1, -1};
		int [] revX = {1, -1, -1, 1};
		int [][][] poly = new int[5][][];
		int [][] tMap = new int[N][M];
		int max = 0;
		poly[0] = new int[][]{{0, 0, 0, 0}, {0, 1, 2, 3}};
		poly[1] = new int[][]{{0, 0, 1, 1}, {0, 1, 0, 1}};
		poly[2] = new int[][]{{0, 0, 1, 2}, {0, 1, 0, 0}};
		poly[3] = new int[][]{{0, 1, 0, -1}, {0, 0, 1, 1}};
		poly[4] = new int[][]{{0, 0, 0, -1}, {0, -1, 1, 0}};
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				tMap[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int[][] polyElem : poly){
			for (int rev = 0; rev < 2; rev++) {
				for (int i = 0; i < 4; i++) { //µµÇü ¼±ÅÃ
					for (int j1 = 0; j1 < N; j1++) { //ÁÂÇ¥ Y
						for (int j2 = 0; j2 < M; j2++) { //ÁÂÇ¥ X
							int sum = 0;
							for (int k = 0; k < 4; k++) {
								int elemX, elemY;
								if(rev == 0){
									elemY = j1 + (polyElem[0][k] * revY[i]);
									elemX = j2 + (polyElem[1][k] * revX[i]);
								} else{
									elemY = j1 + (polyElem[1][k] * revY[i]);
									elemX = j2 + (polyElem[0][k] * revX[i]);
								}
								if(elemX < 0 || elemY < 0 || elemX >= M || elemY >= N){
									sum = 0;
									break;
								}
								sum += tMap[elemY][elemX];
							}
							if(sum != 0)
								max = (sum > max) ? sum : max;
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
