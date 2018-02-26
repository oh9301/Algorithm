import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p14584 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] pwArr = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());
		String[] stArr = new String[N];
		for (int i = 0; i < N; i++) {
			stArr[i] = br.readLine();
		}
		boolean flag = false;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < pwArr.length; j++) {
				if(pwArr[j] - 1 < 'a')
					pwArr[j] = (char)(pwArr[j] + 25);
				else
					pwArr[j] = (char)(pwArr[j] - 1);
			}
			for (String word : stArr) {
				if((new String(pwArr)).contains(word)){
					System.out.println(new String(pwArr));
					flag = true;
					break;
				}
			}
			if(flag)
				break;
			
		}
	}

}
