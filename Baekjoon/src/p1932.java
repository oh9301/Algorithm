import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] triangle = new int[N][];
		int max = 0;
		for (int i = 0; i < N; i++) {
			triangle[i] = new int[i+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < triangle.length-1; i++) {
			for (int j = 0; j <= i+1; j++) {
				if(j == 0)
					triangle[i+1][j] += triangle[i][j];
				else if(j == i+1)
					triangle[i+1][j] += triangle[i][j-1];
				else
					triangle[i+1][j] += Math.max(triangle[i][j-1], triangle[i][j]);
			}
		}
		
		for (int i = 0; i < triangle.length; i++) {
			if(max < triangle[N-1][i])
				max = triangle[N-1][i];
		}
		System.out.println(max);
	}

}
