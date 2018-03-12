package boj;
import java.util.Scanner;

/*
한수는 2차원 배열 (항상 2^N * 2^N 크기이다)을 Z모양으로 탐색하려고 한다. 
예를 들어, 2*2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.

만약, 2차원 배열의 크기가 2^N * 2^N라서 왼쪽 위에 있는 칸이 하나가 아니라면, 배열을 4등분 한 후에 (크기가 같은 2^(N-1)로) 재귀적으로 순서대로 방문한다.

N이 주어졌을 때, (r, c)를 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

첫째 줄에 N r c가 주어진다. N은 15보다 작거나 같은 자연수이고, r과 c는 0보다 크거나 같고, 2^N-1보다 작거나 같은 정수이다
첫째 줄에 문제의 정답을 출력한다.

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
