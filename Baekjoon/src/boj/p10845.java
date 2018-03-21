package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] queueArr = new int[N];
		int eIndex = -1;
		int fIndex = 0;
		int size = 0;
		for (int t = 0; t < N; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmword = st.nextToken();
			if(cmword.equals("push")){
				eIndex++;
				size++;
				queueArr[eIndex] = Integer.parseInt(st.nextToken());
			} else if(cmword.equals("pop")){
				if(size == 0){
					System.out.println(-1);
				} else{
					System.out.println(queueArr[fIndex]);
					fIndex++;
					size--;
				}
			} else if(cmword.equals("empty")){
				System.out.println((size == 0) ? 1 : 0);
			} else if(cmword.equals("size")){
				System.out.println(size);
			} else if(cmword.equals("front")){
				if(size == 0)
					System.out.println(-1);
				else
					System.out.println(queueArr[fIndex]);
			} else if(cmword.equals("back")){
				if(size == 0)
					System.out.println(-1);
				else
					System.out.println(queueArr[eIndex]);
			}
		}
	}

}
