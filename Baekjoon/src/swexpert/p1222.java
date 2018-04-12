package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1222 {
	
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = 0;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(),"+");
			for (int i = 0; i < N/2+1; i++)
				answer += Integer.parseInt(st.nextToken());
			System.out.println("#"+t+" "+answer);
		}
	}

}
