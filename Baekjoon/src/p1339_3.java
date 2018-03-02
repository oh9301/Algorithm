import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2
GCF
ACDEB
*/
// 더 간단한 방법 (String 치환 x)
public class p1339_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String str;
		String[] strArr = new String[N];
		int[] alphaValArr = new int[26];
		for (int i = 0; i < N; i++){
			str = br.readLine();
			strArr[i] = str;
			for (int j = 0; j < str.length(); j++)
				alphaValArr[str.charAt(j) - 'A'] += (int)Math.pow(10, str.length() - j - 1);
		}
		
		int rNum = 9;
		Arrays.sort(alphaValArr);
		for (int i = alphaValArr.length-1; i >= 0; i--) {
			if(alphaValArr[i] == 0)
				break;
			sum += alphaValArr[i] * rNum;
			rNum--;
		}

		System.out.println(sum);
	}

}

