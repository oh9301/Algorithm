import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class p2295 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				for (int k = j; k < N; k++) {
					if(arr[i] + arr[j] + arr[k] > arr[N-1])
						break;
					if(Arrays.binarySearch(arr, arr[i] + arr[j] + arr[k]) >= 0)
						max = (max < arr[i] + arr[j] + arr[k]) ? arr[i] + arr[j] + arr[k] : max; 
				}
			}
		}
		System.out.println(max);
		
	}

}

