package boj;
import java.util.Scanner;

public class p1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int [] arr = new int[N+1];
		arr[1] = 0;
		if(N == 1){
			System.out.println(arr[N]);
			return;
		}
		for (int i = 2; i <= N; i++) {
			if(i % 6 == 0)
				arr[i] = Math.min(Math.min(arr[i-1] + 1, arr[i/2] + 1), arr[i/3] + 1);
			else if(i % 2 == 0){
				arr[i] = Math.min(arr[i-1] + 1, arr[i/2] + 1);
			} else if(i % 3 == 0){
				arr[i] = Math.min(arr[i-1] + 1, arr[i/3] + 1);
			} else
				arr[i] = arr[i-1] + 1;
		}
		System.out.println(arr[N]);
	}

}
