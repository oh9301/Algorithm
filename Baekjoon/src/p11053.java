import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nArr = new int[N];
		int[] dpArr = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			if (dpArr[nArr[i]] == 0)
				dpArr[nArr[i]] = 1;
			for (int j = 0; j < i; j++) {
				if (nArr[j] < nArr[i])
					dpArr[nArr[i]] = Math.max(dpArr[nArr[i]], dpArr[nArr[j]] + 1);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = (max < dpArr[nArr[i]]) ? dpArr[nArr[i]] : max;
		}
		System.out.println(max);
	}
}
