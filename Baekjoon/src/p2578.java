import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2578 {
	
	static int [][] bingoPan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingoPan = new int[5][5];
		int input = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++)
				bingoPan[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				input = Integer.parseInt(st.nextToken());
				searchBingoNum(input);
				if(countBingoRow() >= 3){
					System.out.println(i*5 + (j+1));
					return;
				}
					
			}
		}
	}
	
	public static void searchBingoNum(int num){
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(bingoPan[i][j] == num){
					bingoPan[i][j] = 0;
					return;
				}
			}
		}
	}
	
	public static int countBingoRow(){
		int count = 0;
		int sumX = 0;
		int sumY = 0;
		int sumZ = 0;
		int sumRevZ = 0;
		for (int i = 0; i < 5; i++) {
			sumX = 0;
			sumY = 0;
			for (int j = 0; j < 5; j++) {
				sumX += bingoPan[i][j];
				sumY += bingoPan[j][i];
			}
			if(sumX == 0)
				count++;
			if(sumY == 0)
				count++;
			sumZ += bingoPan[i][i];
			sumRevZ += bingoPan[i][4-i];
		}
		if(sumZ == 0)
			count++;
		if(sumRevZ == 0)
			count++;
		return count;
	}

}
