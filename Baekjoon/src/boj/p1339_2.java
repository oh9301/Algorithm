package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
2
GCF
ACDEB
*/
public class p1339_2 {

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
		int[] sortValArr = alphaValArr.clone();
		
		int rNum = 9;
		Arrays.sort(sortValArr);
		for (int i = sortValArr.length-1; i >= 0; i--) {
			if(sortValArr[i] == 0)
				break;
			for (int j = 0; j < alphaValArr.length; j++) {
				if(sortValArr[i] == alphaValArr[j]){
					for (int k = 0; k < strArr.length; k++)
						strArr[k] = strArr[k].replace(((char)(j + 'A'))+"", rNum+"");
					rNum--;
					alphaValArr[j] = 0;
					break;
				}
			}
		}
		
		for(String s : strArr){
			sum += Integer.parseInt(s);
		}

		System.out.println(sum);
	}

}

