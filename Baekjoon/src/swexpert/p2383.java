package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class p2383 {

	static int answer;
	static int[][] map;
	static int N;
	static ArrayList<Point> fArr;
	static Point[] eArr;
	static ArrayList<Point[]> saveList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			fArr = new ArrayList<>();
			eArr = new Point[2];
			saveList = new ArrayList<>();
			int fcnt = 0, ecnt = 0;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						fArr.add(new Point(i, j));
						fcnt++;
					} else if (map[i][j] >= 2) {
						eArr[ecnt] = new Point(i, j);
						ecnt++;
					}
				}
			}
			setPathList(0, 0, new ArrayList<Point>());
			calcAllCase();
			System.out.println("#" + (t+1) + " " +  (answer + 1));
		}

	}

	public static void setPathList(int index, int len, ArrayList<Point> tmpList) {
		Point[] p = new Point[len];
		for (int i = 0; i < len; i++)
			p[i] = tmpList.get(i);
		saveList.add(p);
		
		for (int i = index; i < fArr.size(); i++) {
			tmpList.add(len, fArr.get(i));
			setPathList(i + 1, len + 1, tmpList);
			tmpList.remove(len);
		}
	}

	public static void calcAllCase() {
		for (int i = 0; i < saveList.size(); i++) {
			int[] lenArr1 = new int[N * 2];
			int[] lenArr2 = new int[N * 2];
			ArrayList<Point> tmp = (ArrayList<Point>) fArr.clone();
			for (Point p : saveList.get(i)) {
				lenArr1[Math.abs(p.x - eArr[0].x) + Math.abs(p.y - eArr[0].y)] += 1;
				tmp.remove(p);
			}
			for (Point p : tmp)
				lenArr2[Math.abs(p.x - eArr[1].x) + Math.abs(p.y - eArr[1].y)] += 1;

			if (answer == 0)
				answer = calcPathTime(lenArr1, lenArr2);
			else
				answer = Math.min(calcPathTime(lenArr1, lenArr2), answer);
		}
	}

	public static int calcPathTime(int[] lenArr1, int[] lenArr2) {
		int res1 = 0, res2 = 0;
		int fNum1 = 0, fNum2 = 0;
		for (int i = 0; i < lenArr1.length; i++) {
			if (i - map[eArr[0].x][eArr[0].y] >= 0)
				fNum1 -= lenArr1[i - map[eArr[0].x][eArr[0].y]];
			if (lenArr1[i] == 0)
				continue;
			if (lenArr1[i] + fNum1 <= 3)
				fNum1 += lenArr1[i];
			else if (fNum1 + lenArr1[i] > 3 && i + 1 < lenArr1.length) {
				lenArr1[i + 1] += lenArr1[i] - (3 - fNum1);
				lenArr1[i] = (3 - fNum1);
				fNum1 = 3;
			}
			res1 = i;
		}
		for (int i = 0; i < lenArr2.length; i++) {
			if (i - map[eArr[1].x][eArr[1].y] >= 0)
				fNum2 -= lenArr2[i - map[eArr[1].x][eArr[1].y]];
			if (lenArr2[i] == 0)
				continue;
			if (lenArr2[i] + fNum2 <= 3)
				fNum2 += lenArr2[i];
			else if (fNum2 + lenArr2[i] > 3 && i + 1 < lenArr2.length) {
				lenArr2[i + 1] += lenArr2[i] - (3 - fNum2);
				lenArr2[i] = (3 - fNum2);
				fNum2 = 3;
			}
			res2 = i;
		}

		return Math.max(res1 + map[eArr[0].x][eArr[0].y], res2 + map[eArr[1].x][eArr[1].y]);
	}

}
//#1 9
//#2 8
//#3 9
//#4 7
//#5 8
//#6 8
//#7 11
//#8 11
//#9 18
//#10 12