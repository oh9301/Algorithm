package boj;
import java.util.Arrays;
import java.util.Scanner;
/*
5 1
-7 -3 -2 5 8
*/
public class p1182 {
	
	static int answer;
	static int [] nArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		nArr = new int[N];
		for (int i = 0; i < N; i++) {
			nArr[i] = sc.nextInt();
		}
		
		Arrays.sort(nArr);
		searchSum(0, 0, S);
		System.out.println(answer);
	}
	
	public static void searchSum(int sum, int start, int S){
		int tmp = 0;
		for (int i = start; i < nArr.length; i++) {
			tmp = sum + nArr[i];
//			if(tmp > S)
//				break;
			if(tmp == S)
				answer++;
			searchSum(tmp, i+1, S);
		}
	}

}
