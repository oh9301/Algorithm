import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플루이드
public class p11404 {

	static final int INF = 1000001;
	static int n;
	static int m;
	static int[][] resMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		resMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(resMap[i], INF);
			resMap[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			if (resMap[row - 1][col - 1] > val)
				resMap[row - 1][col - 1] = val;
		}

		calcFloyid();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(resMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void calcFloyid() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					resMap[i][j] = Math.min(resMap[i][j], resMap[i][k] + resMap[k][j]);
				}
			}
		}

	}

}
