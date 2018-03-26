package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2230 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] iArr = new int[N];
		int min = 2000000000;
		
		for (int i = 0; i < iArr.length; i++)
			iArr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(iArr);
		
		int start = 0;
		int end = 0;
		int sub = 0;
		while(true){
			sub = iArr[end] - iArr[start];
			if(sub < M && end < iArr.length-1){
				end++;
				continue;
			}
			if(sub == M){
				min = M;
				break;
			} else if(sub > M){
				min = (min > sub) ? sub : min;
				start++;
			}
			if(end == iArr.length - 1 && sub < M)
				break;
		}
		
		System.out.println(min);
	}

}