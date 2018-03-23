package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p1931 {
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] elemArr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			elemArr[i][0] = Integer.parseInt(st.nextToken());
			elemArr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(elemArr, new Comparator<int []>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int endIndex = 0;
		for (int i = 0; i < elemArr.length; i++) {
			if(endIndex <= elemArr[i][0]){
				answer++;
				endIndex = elemArr[i][1];
			}
		}
		
		System.out.println(answer);
	}

}
