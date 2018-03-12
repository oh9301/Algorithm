package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 배열 사용 (144MS)
public class p1699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] nArr = new int[N+1];
		int [] check = new int[N+1]; 
		
		double sqrtN = 0;
		int st = 0;
		
		for (int i = 1; i <= N; i++) {
			sqrtN = Math.sqrt(i);
			if(sqrtN == (int) sqrtN){
				nArr[i] = 1;
				check[st] = i;
				st++;
			}
			else{
				int min = 100000;
				for(int j = 0 ; j < st ; j++){
					min = Math.min(nArr[check[j]] + nArr[i-check[j]], min); 
				}
				nArr[i] = min;
			}
		}
		System.out.println(nArr[N]);
	}

}