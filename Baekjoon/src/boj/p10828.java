package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stackArr = new int[N];
		int curIndex = -1;
		int size = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmword = st.nextToken();
			if(cmword.equals("push")){
				curIndex++;
				stackArr[curIndex] = Integer.parseInt(st.nextToken());
				size++;
			} else if(cmword.equals("top")){
				System.out.println((curIndex < 0) ? curIndex : stackArr[curIndex]);
			} else if(cmword.equals("size")){
				System.out.println(size);
			} else if(cmword.equals("empty")){
				System.out.println((size == 0) ? 1 : 0);
			} else if(cmword.equals("pop")){
				if(curIndex == -1)
					System.out.println(curIndex);
				else{
					System.out.println(stackArr[curIndex]);
					curIndex--;
					size--;
				}
			}
		}
	}

}
