import java.util.Scanner;

public class p1012 {

	static int answer;
	static int[][] mnArr;
	static int M;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tCase = 0; tCase < T; tCase++) {
			M = sc.nextInt();
			N = sc.nextInt();
			int K = sc.nextInt();
			mnArr = new int[M][N];
			answer = 0;
			for (int i = 0; i < K; i++) {
				mnArr[sc.nextInt()][sc.nextInt()] = 1;
			}

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (mnArr[i][j] == 1) {
						answer++;
						searchWorm(i, j);
					}

				}
			}
			System.out.println(answer);
		}
	}

	public static void searchWorm(int row, int col) {
		mnArr[row][col] = 2;

		if (row < M - 1 && mnArr[row + 1][col] == 1) {
			searchWorm(row + 1, col);
		}
		
		if (row > 0 && mnArr[row-1][col] == 1) {
			searchWorm(row - 1, col);
		}
		
		if (col < N-1 && mnArr[row][col+1] == 1) {
			searchWorm(row, col+1);
		}
		
		if (col > 0 && mnArr[row][col-1] == 1) {
			searchWorm(row, col-1);
		}

	}

}
