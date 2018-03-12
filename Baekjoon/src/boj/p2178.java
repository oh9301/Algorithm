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
		
		//��
		if(row < N-1 && roadArr[row+1][col] > 0){
			if(roadArr[row+1][col] == 1 || roadArr[row+1][col] > roadArr[row][col] + 1){
				roadArr[row+1][col] = roadArr[row][col] + 1;
				getMinRoadCount(row+1, col);
			}
		}
		
		//��
		if(row > 0 && roadArr[row-1][col] > 0){
			if(roadArr[row-1][col] == 1 || roadArr[row-1][col] > roadArr[row][col] + 1){
				roadArr[row-1][col] = roadArr[row][col] + 1;
				getMinRoadCount(row-1, col);
			}
		}
		
		//����
		if(col < M-1 && roadArr[row][col+1] > 0){
			if(roadArr[row][col+1] == 1 || roadArr[row][col+1] > roadArr[row][col] + 1){
				roadArr[row][col+1] = roadArr[row][col] + 1;
				getMinRoadCount(row, col+1);
			}
		}
		
		//��
		if(col > 0 && roadArr[row][col-1] > 0){
			if(roadArr[row][col-1] == 1 || roadArr[row][col-1] > roadArr[row][col] + 1){
				roadArr[row][col-1] = roadArr[row][col] + 1;
				getMinRoadCount(row, col-1);
			}
		}
		
	}

}


/*
N��Mũ���� �迭�� ǥ���Ǵ� �̷ΰ� �ִ�.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
�̷ο��� 1�� �̵��� �� �ִ� ĭ�� ��Ÿ����, 0�� �̵��� �� ���� ĭ�� ��Ÿ����. �̷��� �̷ΰ� �־����� ��, 
(1, 1)���� ����Ͽ� (N, M)�� ��ġ�� �̵��� �� ������ �ϴ� �ּ��� ĭ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� �������� 15ĭ�� ������ (N, M)�� ��ġ�� �̵��� �� �ִ�. ĭ�� �� ������ ���� ��ġ�� ���� ��ġ�� �����Ѵ�.

ù° �ٿ� �� ���� N, M(2��N, M��100)�� �־�����. ���� N���� �ٿ��� M���� ������ �̷ΰ� �־�����. ������ ������ �پ �Է����� �־�����.

4 6
101111
101010
101011
111011

15

*/