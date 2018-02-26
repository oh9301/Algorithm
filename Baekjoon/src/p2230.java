import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class p2230 {
	
	static HashSet<Integer> fSet;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sub = 0;
		int[] iArr = new int[N];
		fSet = new HashSet<Integer>();
		
		
		for (int i = 0; i < N; i++)
			iArr[i] = sc.nextInt();
		
		if(N == 1 || M == 0){
			System.out.println(0);
			return;
		}
		
		Arrays.sort(iArr);
		
		for (int i = 0; i < iArr.length-1; i++){
			sub = iArr[i+1] - iArr[i];
			if(sub > M){
				fSet.add(sub);
				continue;
			}
			for (int sVal : fSet) {
				fSet.add(sVal + sub);
			}
			fSet.add(sub);

		}
		
		ArrayList<Integer> fList = new ArrayList<Integer>(fSet);
		Collections.sort(fList);
		
		for(int i : fList){
			if(i >= M){
				System.out.println(i);
				break;
			}
		}
	}

}

/*
[문제]
N(1≤N≤100,000)개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에서 두 수를 골랐을 때(같은 수일 수도 있다),
 그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하시오.

예를 들어 수열이 {1, 2, 3, 4, 5}라고 하자. 만약 M=3일 경우, 1 4, 1 5, 2 5를 골랐을 때 그 차이가 M 이상이 된다.
 이 중에서 차이가 가장 작은 경우는 1 4나 2 5를 골랐을 때의 3이 된다.
 
[입력]
 첫째 줄에 두 정수 N, M(0≤M≤2,000,000,000)이 주어진다. 다음 N개의 줄에는 차례로 A[1], A[2], …, A[N]이 주어진다.
  각각의 A[i]는 0 ≤ |A[i]| ≤ 1,000,000,000을 만족한다.
  
[출력]
 첫째 줄에 M 이상이면서 가장 작은 차이를 출력한다. 항상 차이가 M이상인 두 수를 고를 수 있다.
 
3 3
1
5
3

4
*/