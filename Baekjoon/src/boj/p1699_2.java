package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// SET »ç¿ë (284MS)
public class p1699_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] nArr = new int[N+1];
		HashSet<Integer> set = new HashSet<>();
		
		nArr[1] = 1;
		double sqrtN = 0;
		//3248ms
		for (int i = 1; i <= N; i++) {
			sqrtN = Math.sqrt(i);
			if(sqrtN == (int) sqrtN){
				nArr[i] = 1;
				set.add(i);
			}
			else{
				int min = 100000;
				for(int sNum : set){
					min = Math.min(nArr[sNum] + nArr[i-sNum], min); 
				}
				nArr[i] = min;
			}
		}
		System.out.println(nArr[N]);
	}

}