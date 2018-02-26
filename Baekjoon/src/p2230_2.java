import java.util.Arrays;
import java.util.Scanner;

public class p2230_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] iArr = new int[N];
		int min = 2000000000;
		
		for (int i = 0; i < iArr.length; i++) {
			iArr[i] = sc.nextInt();
		}
		
		Arrays.sort(iArr);
		
		int start = 0;
		int end = 0;
		int sub = 0;
		while(true){
			sub = iArr[end] - iArr[start];
			if(sub < M && end < iArr.length-1){
				end++;
				continue;
			}
			if(sub == M){
				min = M;
				break;
			} else if(sub > M){
				min = (min > sub) ? sub : min;
				start++;
			}
			if(end == iArr.length - 1 && sub < M)
				break;
		}
		
		System.out.println(min);
	}

}