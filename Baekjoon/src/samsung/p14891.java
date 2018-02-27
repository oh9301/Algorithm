package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
10010011
01010011
11100011
01010101
8
1 1
2 1
3 1
4 1
1 -1
2 -1
3 -1
4 -1

5
*/

class Link{
	int x;
	int y;
	
	Link(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class p14891 {

	static char[][] whArr;
	static int[][] currentPos = { { 2, 6 }, { 2, 6 }, { 2, 6 }, { 2, 6 } };
	static Set<Link> rcSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		whArr = new char[4][];
		int[][] nArr;
		for (int i = 0; i < whArr.length; i++){
			whArr[i] = br.readLine().toCharArray();
		}
		
		int K = Integer.parseInt(br.readLine());
		nArr = new int[K][2];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nArr[i][0] = Integer.parseInt(st.nextToken()) - 1;
			nArr[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int r = 0; r < K; r++) {
			boolean[] visit = new boolean[4];
			rcSet = new HashSet<>();
			for (int j = 0; j < 3; j++) {
				if (whArr[j+1][currentPos[j+1][1]] - whArr[j][currentPos[j][0]] != 0) {
					rcSet.add(new Link(j, j+1));
				}
			};
			rotateWheel(nArr[r][0], nArr[r][1], visit);
		}
		System.out.println(getAnswer());
	}

	public static void rotateWheel(int wheel, int rot, boolean[] visit) {
		visit[wheel] = true;
		if(rot == -1){
			currentPos[wheel][0] = (currentPos[wheel][0] + 1) % 8;
			currentPos[wheel][1] = (currentPos[wheel][1] + 1) % 8;
		} else{
			currentPos[wheel][0] = (currentPos[wheel][0] + 7) % 8;
			currentPos[wheel][1] = (currentPos[wheel][1] + 7) % 8;
		}
		for (Link l : rcSet) {
			if((l.y == wheel+1) && visit[wheel+1] == false){
				rotateWheel(wheel+1, rot * -1, visit);
			}
			if((l.x == wheel-1) && visit[wheel-1] == false){
				rotateWheel(wheel-1, rot * -1, visit);
			}
		}
		return;
	}
	
	public static int getAnswer(){
		int ans = 0;
		for (int i = 0; i < currentPos.length; i++) {
			if(whArr[i][(currentPos[i][0] -2 + 8) % 8] == '0'){
				continue;
			}
			if(i == 0)	ans += 1; 
			if(i == 1)	ans += 2;
			if(i == 2)	ans += 4;
			if(i == 3)	ans += 8;
		}
		return ans;
	}

}
