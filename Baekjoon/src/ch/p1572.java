package ch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
/*
10 9
3
4
5
6
7
8
9
10
11
12

10 3
2
3
0
3
4
0
0
0
1
3
*/
// 6600ms
public class p1572 {
	
	static long answer;
	static int N;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		N = Integer.parseInt(nk[0]);
		int K = Integer.parseInt(nk[1]);
		list = new ArrayList<>();
		int convK = (K+1)/2 - 1;
		int[] nArr = new int[N];
		for (int i = 0; i < N; i++) {
			nArr[i] = Integer.parseInt(br.readLine());
		}
		list.add(nArr[0]);
		for (int i = 1; i < N; i++) {
			addElement(nArr[i]);
			if(i >= K)
				list.remove((Integer) nArr[i-K]);
			if(i >= K-1){
				answer += list.get(convK);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void addElement(int val){
		if(list.get(0) > val){
			list.add(0, val);
			return;
		}
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i) > val && list.get(i-1) <= val){
				list.add(i, val);
				return;
			}
		}
		list.add(val);
	}
	
}

//6600ms ¼º°ø
/*
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String[] nk = br.readLine().split(" ");
N = Integer.parseInt(nk[0]);
int K = Integer.parseInt(nk[1]);
ArrayList<Integer> list = new ArrayList<>();
convK = (K+1)/2 - 1;
nArr = new int[N];
for (int i = 0; i < N; i++) {
	nArr[i] = Integer.parseInt(br.readLine());
}
for (int i = 0; i < N; i++) {
	list.add(nArr[i]);
	if(i >= K)
		list.remove((Integer) nArr[i-K]);
	if(i >= K-1){
		Collections.sort(list);
		answer += list.get(convK);
	}
}

System.out.println(answer);
*/
