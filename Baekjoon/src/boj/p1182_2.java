package boj;
import java.util.Scanner;

public class p1182_2 {

	public static int N;
	public static int S;
	public static int[] A;
	public static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		solve(0,"",0);
		System.out.println(count);
		sc.close();
	}
	
	public static void solve(int i, String sum, int chk){
		System.out.println(sum);
		if(i <= N-1){
			solve(i+1, sum + A[i], chk + 1);
			solve(i+1, sum, chk);
		}
		
	}

}
