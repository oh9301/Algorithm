package boj;
import java.util.ArrayList;
import java.util.Scanner;

public class p2644 {
	
	static int[][] nArr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int m = sc.nextInt();
		nArr = new int[N+1][N+1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			nArr[x][y] = 1;
			nArr[y][x] = 1;
		}
		
		execBFS(N, t1, t2);
		
//		for (int i = 0; i < nArr.length; i++) {
//			for (int j = 0; j < nArr.length; j++) {
//				System.out.print(nArr[i][j] + " ");
//			}
//			System.out.println();
//		}
		
	}
	
	public static void execBFS(int n, int t1, int t2){
		int answer = 0;
		ArrayList<Integer> curQueue = new ArrayList<>();
		ArrayList<Integer> nextQueue = new ArrayList<>();
		int[] visit = new int[n+1];
		curQueue.add(t1);
		visit[t1] = 1;
		while(!curQueue.isEmpty()){
			answer++;
			for (int curIndex : curQueue) {
				for (int i = 1; i < nArr.length; i++) {
					if(nArr[curIndex][i] == 1 && visit[i] == 0){
						nextQueue.add(i);
						visit[i] = 1;
						if(i == t2){
							System.out.println(answer);
							return;
						}
					}
				}
			}
			curQueue.clear();
			curQueue.addAll(nextQueue);
			nextQueue.clear();
		}
		System.out.println(-1);
	}

}

