package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
n*n�� ũ���� �볪�� ���� �ִ�. ������� �Ǵٴ� � �������� �볪���� �Ա� �����Ѵ�. 
�׸��� �� ���� �볪���� �� �Ծ� ġ��� ��, ��, ��, �� �� �� ������ �̵��� �Ѵ�. 
�׸��� �� �װ����� �볪���� �Դ´�. �׷��� �� ������ �ִ�.
�� �Ǵٴ� �ſ� ����� ���Ƽ� �볪���� �԰� �ڸ��� �ű�� �� �ű� ������ �� �� �������� �볪���� ���� �־�� �Ѵ�.
���࿡ �׷� ������ ������ �� �Ǵٴ� �Ҹ��� ������ �ܽ� ������ �ϴٰ� �װ� �ȴ�(-_-)

�� �Ǵ��� ������� �̷� �Ǵٸ� �볪�� ���� Ǯ�� ���ƾ� �ϴµ�, � ������ ó���� Ǯ�� ���ƾ� �ϰ�, 
� ������ �̵��� ���Ѿ� �� �� ������ ���������� �Ǵٰ� �ִ��� ���� �� �� �ִ��� ��ο� ���� �ִ�. 
�츮�� �ӹ��� �� �����縦 �����ִ� ���̴�. n*n ũ���� �볪�� ���� �־��� ���� ��, �� �Ǵٰ� �ִ��� ���� ����� � ��θ� ���Ͽ� �������� �ϴ��� ���Ͽ���.

4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8

4
14 9 12 10
1 11 5 4
7 2 2 2
6 3 2 8

*/
public class p1937 {
	
	static int N;
	static int max;
	static int [][] nArr;
	static int [][] maxArr;
	static int[] pX = {1, -1, 0, 0};
	static int[] pY = {0, 0, 1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nArr = new int[N][N];
		maxArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				nArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = (max < execDFS(i, j)) ? execDFS(i, j) : max;
			}
		}
		System.out.println(max + 1);
	}
	
	public static int execDFS(int row, int col){
		if(maxArr[row][col] != 0)
			return maxArr[row][col];
		for (int i = 0; i < 4; i++) {
			int nRow = row + pX[i];
			int nCol = col + pY[i];
			
			if(nRow >= 0 && nCol >= 0 && nRow < N && nCol < N 
					&& nArr[nRow][nCol] > nArr[row][col]){
				maxArr[row][col] = Math.max(execDFS(nRow, nCol) + 1, maxArr[row][col]);
			}
		}
		return maxArr[row][col];
	}
}

