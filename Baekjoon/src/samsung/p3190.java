package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Snake{
	int head_x, head_y;
	int tail_x, tail_y;
	int pre_dir;
	ArrayList<BodyPoint> snakeList;
	
	public Snake(int head_x, int head_y, int tail_x, int tail_y, int pre_dir, ArrayList<BodyPoint> snakeList) {
		this.head_x = head_x;
		this.head_y = head_y;
		this.tail_x = tail_x;
		this.tail_y = tail_y;
		this.pre_dir = pre_dir;
		this.snakeList = snakeList;
	}
	
}

class BodyPoint{
	int x;
	int y;
	
	public BodyPoint(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class p3190 {
	
	static int N, K, L;
	static int[][] map;
	static int answer;
	static Snake snake;
	static int[] posX = {0, -1, 0, 1};
	static int[] posY = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = 1;
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
		}
		L = Integer.parseInt(br.readLine());
		ArrayList<BodyPoint> initList = new ArrayList<>();
		initList.add(new BodyPoint(0, 0));
		snake = new Snake(0, 0, 0, 0, 0, initList);
		int preVal = 0;
		for (int i = 0; i <= L; i++) {
			if(i == L){
				if(moveSnake(i, ' ', N) < 0)
					break;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			int dnum = Integer.parseInt(st.nextToken());
			char dist = st.nextToken().charAt(0);
			if(moveSnake(i, dist , dnum - preVal) < 0)
				break;
			preVal = dnum;
		}
		
		System.out.println(answer);
	}
	
	public static int moveSnake(int seq, char dir, int len){
		for (int i = 0; i < len; i++) {
			if(setSnakeLength(snake.pre_dir) < 0){
				return -1;
			}
			answer++;
		}
		if(dir == 'D')
			snake.pre_dir = (snake.pre_dir + 3) % 4;
		else if(dir == 'L')
			snake.pre_dir = (snake.pre_dir + 1) % 4;
		return 1;
	}
	
	public static int setSnakeLength(int dirf){
		if(snake.head_x + posX[dirf] < 0 || snake.head_y + posY[dirf] < 0 || 
				snake.head_x + posX[dirf] >= N || snake.head_y + posY[dirf] >= N)
			return -1;
		snake.head_x = snake.head_x + posX[dirf];
		snake.head_y = snake.head_y + posY[dirf];
		if(map[snake.head_x][snake.head_y] != 1){
			map[snake.tail_x][snake.tail_y] = 0;
			BodyPoint bp = snake.snakeList.remove(0);
			snake.tail_x = bp.x;
			snake.tail_y = bp.y;
		}
		if(map[snake.head_x][snake.head_y] < 0)
			return -1;
		snake.snakeList.add(new BodyPoint(snake.head_x, snake.head_y));
		map[snake.head_x][snake.head_y] = -1;
		return 1;
	}

}
