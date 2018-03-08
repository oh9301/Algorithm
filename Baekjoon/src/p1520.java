import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1520 {
	
	static int M,N;
	static int [][] mnArr;
	static int [][] dpArr;
	static boolean [][] zArr;
	static int [] pX = {-1, 1, 0, 0};
	static int [] pY = {0, 0, -1, 1};

	// 23% 시간 초과 -> 해결하기 위한 zArr(방문 확인 배열)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		mnArr = new int[M][N];
		dpArr = new int[M][N];
		zArr = new boolean[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				mnArr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(getPath(0, 0));
	}
	
	public static int getPath(int row, int col){ 
		if(row == M-1 && col == N-1)
			return 1;
		if(dpArr[row][col] > 0)
			return dpArr[row][col];
		if(zArr[row][col])
			return 0;
		
		for (int i = 0; i < 4; i++) {
			int nx = row + pX[i];
			int ny = col + pY[i];
			if(nx >= 0 && ny >= 0 && nx < M && ny < N && mnArr[nx][ny] < mnArr[row][col])
				dpArr[row][col] += getPath(nx, ny);
		}
		if(dpArr[row][col] == 0)
			zArr[row][col] = true;
		
		return dpArr[row][col];
	}

}