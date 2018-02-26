import java.util.Scanner;

// 욕심쟁이 돼지
/*
유명한 농부 박현수는 돼지 6마리를 키우고 있다. 그는 하루에 한 번씩 돼지에게 맛있는 밥을 준다.

돼지는 원형 식탁에 앉아서 식사를 한다. 
현수의 돼지들은 기억력이 뛰어나기 때문에 전 날 자신의 양쪽과 맞은편에 앉았던 돼지가 먹었던 양을 기억하고 있다.
또, 욕심도 많기 때문에, 그 만큼의 양을 추가하여 식사를 하기를 원한다.

예를 들어, 현수가 1번부터 6번까지 돼지에게 각각 3, 2, 7, 1, 5, 4만큼 밥을 주었다면,
2번 돼지는 첫 날 받은 양 2에다 양쪽과 맞은편 돼지가 받은 양 15(3+7+5)만큼을 더해 17만큼 받기를 원한다.

마음씩 좋은 농부 박현수는 이런 돼지의 요구를 모두 들어주려고 한다. 
매일 현수의 집에 신선한 사료가 N만큼 배달된다. 사료의 유통기한은 하루이기 때문에, 남은 사료는 모두 폐기한다.

첫 날 돼지들이 먹었던 양이 주어졌을 때, 현수가 6마리의 돼지들의 요구를 들어줄 수 없게 되는 날이 몇 번째 날인지 구하는 프로그램을 작성하시오.

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
