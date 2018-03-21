package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2965 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k1 = Integer.parseInt(st.nextToken());
		int k2 = Integer.parseInt(st.nextToken());
		int k3 = Integer.parseInt(st.nextToken());
		
		System.out.println(Math.max(k2 - k1, k3 - k2) - 1);
	}

}
