package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p2531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = 0;
		Set<Integer> sushiSet;
		int[] sushiArr = new int[N];
		for (int i = 0; i < N; i++)
			sushiArr[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < sushiArr.length; i++) {
			sushiSet = new HashSet<>();
			for (int j = 0; j < k; j++)
				sushiSet.add(sushiArr[(i+j)%N]);
			if(sushiSet.contains(c))
				max = (sushiSet.size() > max) ? sushiSet.size() : max;
			else
				max = (sushiSet.size() + 1 > max) ? sushiSet.size() + 1 : max;
		}
		System.out.println(max);
	}
}
