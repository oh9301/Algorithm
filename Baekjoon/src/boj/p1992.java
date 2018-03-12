package boj;
import java.util.Scanner;

/*
�� ������ �����Ͽ� ǥ���ϴ� ������ ������ ���� Ʈ��(Quad Tree)��� ����� �ִ�. 
�� ���� ��Ÿ���� 0�� ���� ���� ��Ÿ���� 1�θ� �̷���� ����(2���� �迭)���� ���� ������ ������ �� ���� ���� ����������, 
���� Ʈ�������� �̸� �����Ͽ� ������ ǥ���� �� �ִ�.

�־��� ������ ��� 0���θ� �Ǿ� ������ ���� ����� "0"�� �ǰ�, ��� 1�θ� �Ǿ� ������ ���� ����� "1"�� �ȴ�. 
���� 0�� 1�� ���� ������ ��ü�� �� ���� ��Ÿ������ ���ϰ�, ���� ��, ������ ��, ���� �Ʒ�, ������ �Ʒ�, �̷��� 4���� �������� ������ �����ϰ� �Ǹ�, 
�� 4���� ������ ������ ����� ���ʴ�� ��ȣ �ȿ� ��� ǥ���Ѵ�

�� �׸����� ������ ������ �������� �迭�� ���� ���ڷ� �־�����, 
�� ������ ���� Ʈ�� ������ �̿��Ͽ� �����ϸ� "(0(0011)(0(0111)01)1)"�� ǥ���ȴ�.  
N ��N ũ���� ������ �־��� ��, �� ������ ������ ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

8
11110000
11110000
00011100
00011100
11110000
11110000
11110011
11110011

((110(0101))(0010)1(0001))

8
11111111
11111111
11111111
11111111
11111111
11111111
11111111
11111110
*/

public class p1992 {

	static char[][] cArr;
	static String answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cArr = new char[N][N];
		answer = "";
		for (int i = 0; i < N; i++) {
			cArr[i] = sc.next().toCharArray();
		}
		
		compressArr(0, N, 0, N);
		System.out.println(answer);
	}

	
	public static void compressArr(int stX, int edX, int stY, int edY){
		char preVal = ' ';
		if(edX == stX){
			answer += cArr[stX][stY];
			return;
		}
		for (int i = stX; i < edX; i++) {
			for (int j = stY; j < edY; j++) {
				if(i == stX && j == stY){
					preVal = cArr[i][j];
					continue;
				}
				if(cArr[i][j] != preVal){
					answer += "(";
					compressArr(stX, (stX+edX)/2, stY, (stY+edY)/2);
					compressArr(stX, (stX+edX)/2, (stY+edY)/2, edY);
					compressArr((stX+edX)/2, edX, stY, (stY+edY)/2);
					compressArr((stX+edX)/2, edX, (stY+edY)/2, edY);
					answer += ")";
					return;
				}
			}
		}
		answer += preVal;
	}
}
