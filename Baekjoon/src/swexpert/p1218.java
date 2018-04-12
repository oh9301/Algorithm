package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1218 {
	
	static int answer, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			examinate(input);
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void examinate(String input){
		char[] arr = new char[N];
		int index = 0;
		for (int i = 0; i < N; i++) {
			char c = input.charAt(i);
			if(c == '{' || c == '(' || c == '[' || c == '<')
				arr[index++] = c;
			else{
				if(index == 0)
					return;
				if(c == '}' && arr[index-1] != '{')
					return;
				else if(c == ']' && arr[index-1] != '[')
					return;
				else if(c == ')' && arr[index-1] != '(')
					return;
				else if(c == '>' && arr[index-1] != '<')
					return;
				index--;
			}
		}
		answer = 1;
	}

}
