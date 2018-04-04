package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class p2477 {

	static int N, M, K, A, B;
	static int answer;
	static Cust[] cArr;
	static int[] nArr, mArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			nArr = new int[N];
			mArr = new int[M];
			cArr = new Cust[K];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				nArr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				mArr[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < K; c++)
				cArr[c] = new Cust(c, Integer.parseInt(st.nextToken()), -1, -1, -1, -1);
			
			simulGarage();
			for (int i = 0; i < cArr.length; i++) {
				if(cArr[i].firstVisit == A - 1 && cArr[i].secondVisit == B - 1)
					answer += cArr[i].id + 1;
			}
			System.out.println("#"+t+" " + ((answer == 0) ? -1 : answer));
		}
	}
	
	public static void simulGarage(){
		int t = 0;
		int[] completed = new int[K];
		Cust[] receptDesk = new Cust[N];
		Cust[] repairDesk = new Cust[M];
		ArrayList<Cust> tmpList; 
		ArrayList<Cust> waitList = new ArrayList<>();
		while(true){
			tmpList = new ArrayList<>();
			for (int i = 0; i < cArr.length; i++) {
				if(cArr[i].firstVisit == -1){
					if(cArr[i].k <= t){
						for (int j = 0; j < receptDesk.length; j++) {
							if(receptDesk[j] == null){
//								System.out.println("1 ���� (" + cArr[i].id + ") : " + t + " ");
								receptDesk[j] = cArr[i];
								cArr[i].firstVisit = j;
								cArr[i].firstExitk = t + nArr[j];
								break;
							}
						}
					}
				} else{
					if(t == cArr[i].firstExitk){
						receptDesk[cArr[i].firstVisit] = null;
//						System.out.println("1 Ż�� (" + cArr[i].id + ") : " + t + " ");
						tmpList.add(cArr[i]);
					}
				}
			}
			if(tmpList.size() > 1){
				Collections.sort(tmpList, new Comparator<Cust>() {
					@Override
					public int compare(Cust o1, Cust o2) {
						return o1.firstVisit - o2.firstVisit;
					}
				});
			}
			waitList.addAll(tmpList);
			for (Cust c : waitList) {
				if(c.secondVisit == -1){
					for (int j = 0; j < repairDesk.length; j++) {
						if(repairDesk[j] == null){
//							System.out.println("2 ���� (" + c.id + ") : " + t + " ");
							repairDesk[j] = c;
							c.secondVisit = j;
							c.secondExitk = t + mArr[j];
							break;
						}
					}
				} else{
					if(t == c.secondExitk){
						repairDesk[c.secondVisit] = null;
//						System.out.println("2 Ż�� (" + c.id + ") : " + t + " ");
						completed[c.id] = 1;
					}
				}
			}
			int sum = 0;
			for (int i = 0; i < completed.length; i++) {
				sum += completed[i];
			}
			if(sum == K){
//				for (Cust c : waitList) {
//					System.out.println((c.id + 1) + " / " + c.firstVisit + "( " + c.firstExitk + " ) " + " / " + c.secondVisit + "( " + c.secondExitk + " )");
//				}
				break;
			}
			t++;
		}
	}

	/*
	 * ���� â���� �켱������ �Ʒ��� ����.
	 * 
	 * �� ���� ���� ��ٸ��� �ִ� ��� ����ȣ�� ���� ������� �켱 �����Ѵ�. �� �� â���� ���� ���� ��� ���� â����ȣ�� ����
	 * ������ ����.
	 * 
	 * ���� â���� �켱������ �Ʒ��� ����.
	 * 
	 * �� ���� ��ٸ��� ���� �켱�Ѵ�. �� �� �� �̻��� ������ ���� â������ ���ÿ� ������ �Ϸ��ϰ� ���� â���� �̵��� ���,
	 * �̿��ߴ� ���� â����ȣ�� ���� ���� �켱�Ѵ�. �� �� â���� ���� ���� ��� ���� â����ȣ�� ���� ������ ����.
	 */
}

class Cust {
	int id;
	int k;
	int firstVisit;
	int firstExitk;
	int secondVisit;
	int secondExitk;
	
	public Cust(int id, int k, int firstVisit, int firstExitk, int secondVisit, int secondExitk) {
		this.id = id;
		this.k = k;
		this.firstVisit = firstVisit;
		this.firstExitk = firstExitk;
		this.secondVisit = secondVisit;
		this.secondExitk = secondExitk;
	}

}
