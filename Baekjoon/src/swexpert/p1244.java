package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p1244 {
	
	static int answer, count;
	static String input;
	static ArrayList<Map<String, Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = st.nextToken();
			count = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			for (int i = 0; i <= count; i++) {
				list.add(new HashMap<>());
			}
			dfs(input, 0);
			System.out.println("#" + t + " "+ answer);
		}
	}
	
	public static void dfs(String cStr, int cnt){
		if(list.get(cnt).get(cStr) != null)
			return;
		list.get(cnt).put(cStr, 0);
		if(count == cnt){
			answer = Math.max(Integer.parseInt(cStr), answer);
			return;
		}
		for (int i = 0; i < cStr.length(); i++) {
			for (int j = i+1; j < cStr.length(); j++) {
				dfs(exchangeStr(cStr, i, j), cnt+1);
			}
		}
	}
	
	public static String exchangeStr(String str, int i, int j){
		return str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j+1, str.length());
	}

}
