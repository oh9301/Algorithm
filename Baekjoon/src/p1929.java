import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] nArr = new boolean[N + 1];

		for (int i = 2; i <= N; i++) {
			if (nArr[i])
				continue;
			for (int k = 2; i * k <= N; k++)
				nArr[i * k] = true;
		}

		for (int i = M; i <= N; i++) {
			if (i == 1)
				continue;
			if (!nArr[i])
				System.out.println(i);
		}
	}

}
