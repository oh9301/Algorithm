package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> queue = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int index = 0;
		sb.append("<");
		while(!queue.isEmpty()){
			index = (index + M-1) % queue.size();
			sb.append(queue.remove(index));
			if(queue.size() != 0)
				sb.append(", ");
		}
		sb.append(">");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
