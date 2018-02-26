import java.util.Scanner;

// ������� ����
/*
������ ��� �������� ���� 6������ Ű��� �ִ�. �״� �Ϸ翡 �� ���� �������� ���ִ� ���� �ش�.

������ ���� ��Ź�� �ɾƼ� �Ļ縦 �Ѵ�. 
������ �������� ������ �پ�� ������ �� �� �ڽ��� ���ʰ� ������ �ɾҴ� ������ �Ծ��� ���� ����ϰ� �ִ�.
��, ��ɵ� ���� ������, �� ��ŭ�� ���� �߰��Ͽ� �Ļ縦 �ϱ⸦ ���Ѵ�.

���� ���, ������ 1������ 6������ �������� ���� 3, 2, 7, 1, 5, 4��ŭ ���� �־��ٸ�,
2�� ������ ù �� ���� �� 2���� ���ʰ� ������ ������ ���� �� 15(3+7+5)��ŭ�� ���� 17��ŭ �ޱ⸦ ���Ѵ�.

������ ���� ��� �������� �̷� ������ �䱸�� ��� ����ַ��� �Ѵ�. 
���� ������ ���� �ż��� ��ᰡ N��ŭ ��޵ȴ�. ����� ��������� �Ϸ��̱� ������, ���� ���� ��� ����Ѵ�.

ù �� �������� �Ծ��� ���� �־����� ��, ������ 6������ �������� �䱸�� ����� �� ���� �Ǵ� ���� �� ��° ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

2
21
1 2 3 4 5 6
21
1 2 3 4 5 7

2
1
*/

public class p3060 {
	
	static long [][] state;
	static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			answer = 1;
			int N = sc.nextInt();
			state = new long[6][2];
			for (int i = 0; i < 6; i++)
				state[i][0] = sc.nextLong();
			dailyFoodCount(N);
			System.out.println(answer);
		}
	}
	
	public static void dailyFoodCount(int size){
		long sum = 0;
		for (int i = 0; i < state.length; i++)
			sum += state[i][0];
		while(sum <= size){
			sum = 0;
			for (int i = 0; i < state.length; i++) {
				state[i][1] = state[i][0] + state[(i+5)%6][0] + state[(i+1)%6][0] + state[(i+3)%6][0];
				sum += state[i][1];
			}
			answer++;
			for (int i = 0; i < state.length; i++)
				state[i][0] = state[i][1];
		}
	}

}
