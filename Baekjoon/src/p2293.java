import java.util.Scanner;
/*
시간제한 :	2 초
메모리 :	4 MB

n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 
이 동전들을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. (각각의 동전은 몇 개라도 사용할 수 있다.)

입력
첫째줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다.

출력
첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.

3 10
1
2
5

10
*/
public class p2293 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] valueArr = new int[n];
		int [] dpArr = new int[k+1];
		for (int i = 0; i < n; i++) {
			valueArr[i] = sc.nextInt();
		}
		dpArr[0] = 1;
		for (int val : valueArr) {
			for (int i = 1; i < val; i++) {
				System.out.print("  ");
			}
			for (int i = val; i <= k; i++) {
				dpArr[i] += dpArr[i - val];
				System.out.print(dpArr[i] + " ");
			}
			System.out.println();
		}
		System.out.println(dpArr[k]);
		
	}
	

}
