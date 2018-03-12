package boj;
import java.util.Scanner;

/*
�Ѽ��� 2���� �迭 (�׻� 2^N * 2^N ũ���̴�)�� Z������� Ž���Ϸ��� �Ѵ�. 
���� ���, 2*2�迭�� ���� ��ĭ, ������ ��ĭ, ���� �Ʒ�ĭ, ������ �Ʒ�ĭ ������� �湮�ϸ� Z����̴�.

����, 2���� �迭�� ũ�Ⱑ 2^N * 2^N�� ���� ���� �ִ� ĭ�� �ϳ��� �ƴ϶��, �迭�� 4��� �� �Ŀ� (ũ�Ⱑ ���� 2^(N-1)��) ��������� ������� �湮�Ѵ�.

N�� �־����� ��, (r, c)�� �� ��°�� �湮�ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

ù° �ٿ� N r c�� �־�����. N�� 15���� �۰ų� ���� �ڿ����̰�, r�� c�� 0���� ũ�ų� ����, 2^N-1���� �۰ų� ���� �����̴�
ù° �ٿ� ������ ������ ����Ѵ�.

2 3 1
11

3 7 7
63

*/

public class p1074 {

	static int N;
	static int r;
	static int c;
	static long score;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		int len = (int)Math.pow(2, N);
		getZ(0, len-1, 0, len-1, 0, 0);
		System.out.println(score);
	}
	
	public static void getZ(int startX, int endX, int startY, int endY, int xc, int yc){
//		System.out.println(startX + " " + endX + " " + startY + " " + endY);
		if(endX - startX == 1 && endY - startY == 1){
			score += (r == startY) ? 0 : 2;
			score += (c == startX) ? 0 : 1;
			return;
		}
		if((xc+yc) % 2 == 0){
			if((endY + startY) / 2 >= r)
				getZ(startX, endX, startY, (startY + endY)/2, xc, yc + 1);
			else{
				getZ(startX, endX, (startY + endY)/2 + 1, endY, xc, yc + 1);
				score += Math.pow(2, (N-xc)) * Math.pow(2, (N-(yc+1)));
			}
		} else{
			if((endX + startX) / 2 >= c)
				getZ(startX, (startX + endX)/2, startY, endY, xc + 1, yc);
			else{
				getZ((startX + endX)/2 + 1, endX, startY, endY, xc + 1, yc);
				score += Math.pow(2, (N-(xc+1))) * Math.pow(2, (N-yc));
			}
		}
	}

}
