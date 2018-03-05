import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2531_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] nArr = new int[d+1];
		int max = 0;
		int[] sushiArr = new int[N];
		for (int i = 0; i < N; i++)
			sushiArr[i] = Integer.parseInt(br.readLine());
		
		// ÀüÃ³¸®
		int score = 0;
		for (int i = 0; i < k; i++)
			nArr[sushiArr[i]] += 1;
		for (int i = 0; i <= d; i++) {
			if(nArr[i] > 0)
				max++;
		}
		if(nArr[c] == 0)
			max++;
		
		for (int i = 1; i < sushiArr.length; i++) {
			score = 0;
			nArr[sushiArr[i-1]] -= 1;
			nArr[sushiArr[(i-1+k)%N]] += 1;				
			for (int j = 0; j <= d; j++) {
				if(nArr[j] > 0)
					score++;
			}
			if(nArr[c] == 0)
				score++;
			max = (score > max) ? score : max;
		}
		System.out.println(max);
	}
}
