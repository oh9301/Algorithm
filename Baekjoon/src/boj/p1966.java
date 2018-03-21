package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p1966 {

	static int answer;
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N];
			Set<Integer> set = new HashSet<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++){
				arr[i] = Integer.parseInt(st.nextToken());
				set.add(arr[i]);
			}
			ArrayList<Integer> sortList = new ArrayList<>(set);
			Collections.sort(sortList, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			
			searchPrintSeq(sortList);
			System.out.println(answer);
		}
		
	}
	public static void searchPrintSeq(ArrayList<Integer> sortList){
		int tmp = 0;
		int preIndex = 0;
		for(int elem : sortList){
			preIndex = tmp;
			for (int i = 0; i < N; i++) {
				if(elem == arr[(i+preIndex)%N]){
					tmp = (i+preIndex)%N;
					answer++;
					if((i+preIndex)%N == M)
						return;
				}
			}
		}
	}

}
