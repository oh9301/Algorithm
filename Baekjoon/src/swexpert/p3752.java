package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p3752 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int answer = 1;
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int [] narr = new int[N];
			int vIndex = 0;
			for (int i = 0; i < N; i++) {
				narr[i] = Integer.parseInt(st.nextToken());
				vIndex += narr[i];
			}
			boolean[] visit = new boolean[vIndex + 1];
			Queue<Integer> tmp = new LinkedList<>();
			
			// 2. 체크 배열 활용
			visit[0] = true;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= vIndex; j++) {
					if(visit[j] && !visit[narr[i]+j])
						tmp.add(narr[i] + j);
				}
				while(!tmp.isEmpty()){
					int elem = tmp.poll();
					if(!visit[elem]){
						answer++;
						visit[elem] = true;
					}
				}
			}
			System.out.println("#"+t+" " + answer);
		}
	}

}