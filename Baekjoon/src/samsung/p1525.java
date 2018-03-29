package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1525 {
	
	static int answer = -1;
	static Map<Integer, Integer> check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String map = "";
		for (int i = 0; i < 3; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			map += st.nextToken();
			map += st.nextToken();
			map += st.nextToken();
		}
		check = new HashMap<>();
		BFS(map);
		System.out.println(answer);
	}
	
	public static void BFS(String str){
		String ans = "123456780";
		Queue<String> queue = new LinkedList<>();
		queue.add(str);
		check.put(Integer.parseInt(str), 0);
		while(!queue.isEmpty()){
			int zIndex = -1;
			String nt = null;
			String st = queue.poll();
			if(st.equals(ans)){
				answer = check.get(Integer.parseInt(st));
				return;
			}
			for (int i = 0; i < 9; i++) {
				if(st.charAt(i) == '0'){
					zIndex = i;
					break;
				}
			}
			if(zIndex - 3 >= 0){
				nt = swap(st, zIndex - 3, zIndex);
				if(check.get(Integer.parseInt(nt)) == null){
					check.put(Integer.parseInt(nt), check.get(Integer.parseInt(st)) + 1);
					queue.add(nt);
				}
			}
			if(zIndex + 3 <= 8){
				nt = swap(st, zIndex, zIndex + 3);
				if(check.get(Integer.parseInt(nt)) == null){
					check.put(Integer.parseInt(nt), check.get(Integer.parseInt(st)) + 1);
					queue.add(nt);
				}
			}
			if(zIndex % 3 != 2){
				nt = swap(st, zIndex, zIndex + 1);
				if(check.get(Integer.parseInt(nt)) == null){
					check.put(Integer.parseInt(nt), check.get(Integer.parseInt(st)) + 1);
					queue.add(nt);
				}
			}
			if(zIndex % 3 != 0){
				nt = swap(st, zIndex - 1, zIndex);
				if(check.get(Integer.parseInt(nt)) == null){
					check.put(Integer.parseInt(nt), check.get(Integer.parseInt(st)) + 1);
					queue.add(nt);
				}
			}
		}
	}

	public static String swap(String st, int s, int l){
		return st.substring(0, s) + st.charAt(l) + st.substring(s+1, l) + st.charAt(s) + st.substring(l+1);
	}
}
