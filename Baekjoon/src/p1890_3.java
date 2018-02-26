import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//bfs + memo
public class p1890_3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Point> q = new LinkedList<>();
		int N = sc.nextInt();
		int[][] a = new int[N][N];
		int[][] d = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		q.add(new Point(0, 0));
		d[0][0] = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();
			if (a[p.x][p.y] != 0) {
				int nx = p.x + a[p.x][p.y]; // 아래로
				int ny = p.y + a[p.x][p.y]; // 오른
				if (nx >= 0 && nx < N) { // 아래로 갈 수 있으면
					q.add(new Point(nx, p.y));
					d[nx][p.y] += d[p.x][p.y];
				}
				if (ny >= 0 && ny < N) { // 오른쪽으로 갈 수 있으면
					q.add(new Point(p.x, ny));
					d[p.x][ny] += d[p.x][p.y];
				}
			}
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					System.out.print(d[i][j]+ " ");
				}System.out.println();
			}
			
		}
		System.out.println(d[N-1][N-1]);
		sc.close();
	}
}