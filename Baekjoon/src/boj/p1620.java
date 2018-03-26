package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> nameMap = new HashMap<>();
		String[] indexArr = new String[N+1];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			indexArr[i] = name;
			nameMap.put(name, i);
		}
		
		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			if(input.charAt(0) <= '9' && input.charAt(0) >= '0')
				sb.append(indexArr[Integer.parseInt(input)]).append("\n");
			else
				sb.append(nameMap.get(input)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
