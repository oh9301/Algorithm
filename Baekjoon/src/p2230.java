import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class p2230 {
	
	static HashSet<Integer> fSet;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int sub = 0;
		int[] iArr = new int[N];
		fSet = new HashSet<Integer>();
		
		
		for (int i = 0; i < N; i++)
			iArr[i] = sc.nextInt();
		
		if(N == 1 || M == 0){
			System.out.println(0);
			return;
		}
		
		Arrays.sort(iArr);
		
		for (int i = 0; i < iArr.length-1; i++){
			sub = iArr[i+1] - iArr[i];
			if(sub > M){
				fSet.add(sub);
				continue;
			}
			for (int sVal : fSet) {
				fSet.add(sVal + sub);
			}
			fSet.add(sub);

		}
		
		ArrayList<Integer> fList = new ArrayList<Integer>(fSet);
		Collections.sort(fList);
		
		for(int i : fList){
			if(i >= M){
				System.out.println(i);
				break;
			}
		}
	}

}

/*
[����]
N(1��N��100,000)���� ���� �̷���� ���� A[1], A[2], ��, A[N]�� �ִ�. �� �������� �� ���� ����� ��(���� ���� ���� �ִ�),
 �� ���̰� M �̻��̸鼭 ���� ���� ��츦 ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ��� ������ {1, 2, 3, 4, 5}��� ����. ���� M=3�� ���, 1 4, 1 5, 2 5�� ����� �� �� ���̰� M �̻��� �ȴ�.
 �� �߿��� ���̰� ���� ���� ���� 1 4�� 2 5�� ����� ���� 3�� �ȴ�.
 
[�Է�]
 ù° �ٿ� �� ���� N, M(0��M��2,000,000,000)�� �־�����. ���� N���� �ٿ��� ���ʷ� A[1], A[2], ��, A[N]�� �־�����.
  ������ A[i]�� 0 �� |A[i]| �� 1,000,000,000�� �����Ѵ�.
  
[���]
 ù° �ٿ� M �̻��̸鼭 ���� ���� ���̸� ����Ѵ�. �׻� ���̰� M�̻��� �� ���� �� �� �ִ�.
 
3 3
1
5
3

4
*/