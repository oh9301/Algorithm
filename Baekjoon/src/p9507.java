import java.util.Scanner;
/*
n < 2 :                         1
n = 2 :                         2
n = 3 :                         4
n > 3 : koong(n - 1) + koong(n - 2) + koong(n - 3) + koong(n - 4)
*/
public class p9507 {

	static long [] koong;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] tArr = new int[T];
		int max = 0;
		for (int t = 0; t < T; t++) {
			tArr[t] = sc.nextInt();
			max = (max < tArr[t]) ? tArr[t] : max;
		}
		
		koong = new long[max+1];
		for (int i = 0; i <= max; i++) {
			if(i < 2){	koong[i] = 1;} 
			else if(i == 2){	koong[i] = 2;	} 
			else if(i == 3){	koong[i] = 4;	}
			else{	koong[i] = koong[i-1] + koong[i-2] + koong[i-3] + koong[i-4];	}
		}
		
		for (int i = 0; i < tArr.length; i++) {
			System.out.println(koong[tArr[i]]);
		}
	}

}
