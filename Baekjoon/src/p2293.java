import java.util.Scanner;
/*
�ð����� :	2 ��
�޸� :	4 MB

n���� ������ ������ �ִ�. ������ ������ ��Ÿ���� ��ġ�� �ٸ���. 
�� �������� ������ ����ؼ�, �� ��ġ�� ���� k���� �ǵ��� �ϰ� �ʹ�. �� ����� ���� ���Ͻÿ�. (������ ������ �� ���� ����� �� �ִ�.)

�Է�
ù°�ٿ� n, k�� �־�����. (1 �� n �� 100, 1 �� k �� 10,000) ���� n���� �ٿ��� ������ ������ ��ġ�� �־�����.

���
ù° �ٿ� ����� ���� ����Ѵ�. ����� ���� 2^31���� �۴�.

3 10
1
2
5

10
*/
public class p2293 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] valueArr = new int[n];
		int [] dpArr = new int[k+1];
		for (int i = 0; i < n; i++) {
			valueArr[i] = sc.nextInt();
		}
		dpArr[0] = 1;
		for (int val : valueArr) {
			for (int i = 1; i < val; i++) {
				System.out.print("  ");
			}
			for (int i = val; i <= k; i++) {
				dpArr[i] += dpArr[i - val];
				System.out.print(dpArr[i] + " ");
			}
			System.out.println();
		}
		System.out.println(dpArr[k]);
		
	}
	

}
