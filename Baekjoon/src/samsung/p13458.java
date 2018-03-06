package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p13458 {

	static long answer;
	static int B;
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> elemSet = new HashSet<>(); 
		int[] classArr = new int[1000001];
		int tmp;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			tmp = Integer.parseInt(st.nextToken());
			elemSet.add(tmp);
			classArr[tmp] += 1;
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		for (int elem : elemSet) {
			answer += (long)classArr[elem] * getSupervisorCount(elem); 
		}
		
		System.out.println(answer);
	}
	
	public static int getSupervisorCount(int num){
		int res = 1;
		num = num - B;
		if(num > 0){
			res += (num / C);
			if(num % C != 0)
				res += 1;
		}
		return res;
	}

}
