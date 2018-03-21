package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String answer = null;
		StringBuffer str1, str2, str3;
		for (int i = 1; i <= input.length() - 2; i++) {
			str1 = new StringBuffer();
			str1.append(input.substring(0, i));
			str1.reverse();
			for (int j = i + 1; j <= input.length() - 1; j++) {
				str2 = new StringBuffer();
				str3 = new StringBuffer();
				str2.append(input.substring(i, j));
				str2.reverse();
				str3.append(input.substring(j, input.length()));
				str3.reverse();
				String comp = str1.toString() + str2.toString() + str3.toString();
				if(answer == null)
					answer = comp;
				else{
					answer = (answer.compareTo(comp) > 0) ? comp : answer;
				}
			}
		}
		System.out.println(answer);
		
	}

}
