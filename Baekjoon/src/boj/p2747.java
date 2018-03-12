package boj;
import java.util.Scanner;

public class p2747 {

	static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[n]);
		System.out.println(Fibonachi(n));
	}
	
	public static int Fibonachi(int n){
		if(n == 0 || n == 1 || arr[n] != 0)
			return arr[n];
		else
			return arr[n] = Fibonachi(n-1) + Fibonachi(n-2); 
	}
}
