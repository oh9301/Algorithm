package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class p1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] inArr = new int[n];
		ArrayList<Integer> st = new ArrayList<>();
		ArrayList<Character> seqlist = new ArrayList<>();
		for (int i = 0; i < inArr.length; i++)
			inArr[i] = Integer.parseInt(br.readLine());
		int cnt = 0;
		int elem = 1;
		while (cnt != n) {
			if(inArr[cnt] >= elem){
				st.add(elem);
				seqlist.add('+');
				elem++;
				continue;
			}
			if(st.get(st.size() - 1) == inArr[cnt]){
				st.remove(st.size() - 1);
				seqlist.add('-');
				cnt++;
			} else{
				System.out.println("NO");
				return;
			}
		}
		for(char c : seqlist)
			System.out.println(c);
	}

}
