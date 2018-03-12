package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//일반 DFS 시간초과 3%
//DFS + MEMOI 런타임 50%
//DFS + MEMOI + LONG
public class p1890 {
	
	static int[][] arr;
	static long[][] varr;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		varr = new long[N][N];
		for(int i=0; i<N; i++){
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
			
		long s = execDFS(0, 0);
		System.out.println(s);
	}
	
	public static long execDFS(int i, int j){
		long res = 0;
		if(varr[i][j] != 0)
			return varr[i][j];
		if(i == N-1 && j == N-1)
			return 1;
		if(arr[i][j] == 0)
			return 0;
		if(arr[i][j] + i < N)
			res += execDFS(arr[i][j] + i, j);
		if(arr[i][j] + j < N)
			res += execDFS(i, arr[i][j] + j);
		
		varr[i][j] = res;
		return res;
	}

}
