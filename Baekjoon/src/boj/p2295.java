package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class p2295 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		HashMap<Integer, Integer> chkMap = new HashMap<>();
		for (int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
			chkMap.put(arr[i], 1);
		}
		
		Arrays.sort(arr);
		for (int i = N-1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(arr[i] - arr[j] - arr[k] < 0)
						break;
					if(chkMap.get(arr[i] - arr[j] - arr[k]) != null){
						System.out.println(arr[i]);
						return;
					}
				}
			}
		}
	}

}

