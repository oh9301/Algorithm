package ch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2780 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		//Init psArr
		int[][] pwd = {{1,2,3},{4,5,6},{7,8,9},{0,-1,-1}};
		int[][] path = new int[10][10];
		int[] dirX = {1, -1, 0, 0};
		int[] dirY = {0, 0, 1, -1};
		for (int i = 0; i < pwd.length; i++)
			for (int j = 0; j < pwd[i].length; j++){
				if(pwd[i][j] == -1)
					continue;
				for (int k = 0; k < 4; k++) {
					int nX = j + dirX[k];
					int nY = i + dirY[k];
					if(nX >= 0 && nY >= 0 && nX < 3 && nY < 4 && pwd[nY][nX] != -1){
						path[pwd[nY][nX]][pwd[i][j]] = 1;
						path[pwd[i][j]][pwd[nY][nX]] = 1;
					}
				}
			}
		
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				System.out.print(path[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int t = 0; t < T; t++) {
			
		}
	}

}
