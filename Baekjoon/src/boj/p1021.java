package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1021 {

	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nArr = new int[N];
		ArrayList<Integer> rqueue = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			rqueue.add(i);
		for (int i = 0; i < M; i++){
			nArr[i] = rqueue.get(Integer.parseInt(st.nextToken()) - 1);
		}
		
		int cIndex = 0;
		int qIndex = 0;
		for (int i = 0; i < M; i++) {
			if(rqueue.get(cIndex) != nArr[i]){
				qIndex = rqueue.indexOf(nArr[i]);
				if(Math.abs(qIndex - cIndex) < rqueue.size() - Math.abs(cIndex - qIndex))
					answer += Math.abs(qIndex - cIndex);
				else
					answer += rqueue.size() - Math.abs(cIndex - qIndex);
				rqueue.remove(qIndex);
				if(rqueue.size() != 0)
					cIndex = qIndex%rqueue.size();
			} else{
				rqueue.remove(cIndex);
				if(rqueue.size() != 0)
					cIndex %= rqueue.size();
			}
		}
		System.out.println(answer);
	}

}
