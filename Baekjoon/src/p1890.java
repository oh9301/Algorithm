import java.util.Scanner;

//일반 DFS 시간초과 3%
//DFS + MEMOI 런타임 50%
//DFS + MEMOI + LONG
public class p1890 {
	
	static int[][] arr;
	static long[][] varr;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		varr = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		}
		
		long s = execDFS(0, 0);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(varr[i][j] + " ");
			}
			System.out.println();
		}
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
