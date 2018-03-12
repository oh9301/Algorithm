package boj;
import java.util.Scanner;

public class p2178 {
	
	static int N;
	static int M;
	static int[][] roadArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		roadArr = new int[N][M];
		char[] tmpArr = null;
		
		for (int i = 0; i < N; i++) {
			tmpArr = sc.next().toCharArray();
			for(int j = 0 ; j < M ; j++){
				roadArr[i][j] = tmpArr[j] - '0';
			}
		}
		
		getMinRoadCount(0, 0);
		System.out.println(roadArr[N-1][M-1]);
	}
	
	public static void getMinRoadCount(int row, int col){
		
		if(row == N-1 && col == M-1)
			return;
		
		//밑
		if(row < N-1 && roadArr[row+1][col] > 0){
			if(roadArr[row+1][col] == 1 || roadArr[row+1][col] > roadArr[row][col] + 1){
				roadArr[row+1][col] = roadArr[row][col] + 1;
				getMinRoadCount(row+1, col);
			}
		}
		
		//위
		if(row > 0 && roadArr[row-1][col] > 0){
			if(roadArr[row-1][col] == 1 || roadArr[row-1][col] > roadArr[row][col] + 1){
				roadArr[row-1][col] = roadArr[row][col] + 1;
				getMinRoadCount(row-1, col);
			}
		}
		
		//오른
		if(col < M-1 && roadArr[row][col+1] > 0){
			if(roadArr[row][col+1] == 1 || roadArr[row][col+1] > roadArr[row][col] + 1){
				roadArr[row][col+1] = roadArr[row][col] + 1;
				getMinRoadCount(row, col+1);
			}
		}
		
		//왼
		if(col > 0 && roadArr[row][col-1] > 0){
			if(roadArr[row][col-1] == 1 || roadArr[row][col-1] > roadArr[row][col] + 1){
				roadArr[row][col-1] = roadArr[row][col] + 1;
				getMinRoadCount(row, col-1);
			}
		}
		
	}

}


/*
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, 
(1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

첫째 줄에 두 정수 N, M(2≤N, M≤100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

4 6
101111
101010
101011
111011

15

*/