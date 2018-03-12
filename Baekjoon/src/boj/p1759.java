package boj;
import java.util.Arrays;
import java.util.Scanner;

public class p1759 {
	
	static int answer;
	static char [] wordArr;
	static int L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		int C = sc.nextInt();
		int jcnt = 0;
		int icnt = 0;
		wordArr = new char[C];
		
		for (int i = 0; i < C; i++) {
			wordArr[i] = sc.next().charAt(0);
			if(wordArr[i] == 'a' || wordArr[i] == 'e' || wordArr[i] == 'i' || wordArr[i] == 'o' || wordArr[i] == 'u')
				icnt += 1;
			else
				jcnt += 1;
		}
		
		if(icnt < 1 || jcnt < 2)
			return;
		
		Arrays.sort(wordArr);
		calcPassword("", 0, 0, 0);
		
	}
	
	public static void calcPassword(String res, int index, int xCount, int yCount){
		
		if(res.length() == L && xCount >= 2 && yCount >= 1){
			System.out.println(res);
			return;
		}
		for (int i = index; i < wordArr.length; i++) {
			if(wordArr[i] == 'a' || wordArr[i] == 'e' || wordArr[i] == 'i' || wordArr[i] == 'o' || wordArr[i] == 'u')
				calcPassword(res+wordArr[i], i+1, xCount, yCount+1);
			else
				calcPassword(res+wordArr[i], i+1, xCount+1, yCount);
		}
	}

}
