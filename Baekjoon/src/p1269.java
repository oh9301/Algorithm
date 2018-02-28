import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int [] aArr = new int[A];
		int [] bArr = new int[B]; 

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++){
			aArr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++){
			bArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(aArr);
		Arrays.sort(bArr);

		int result = A + B;
//	case 2 : 이진탐색 
		for (int num : aArr) {
			if(Arrays.binarySearch(bArr, num) >= 0)
				result -= 2;
		}
		
//	case 1 : 반복문 사용
//		while(true){
//			if(aArr[i] == bArr[j]){
//				result -= 2;
//				if(i == A-1 || j == B-1)
//					break;
//				i += 1;
//				j += 1;
//			} else if(aArr[i] > bArr[j]){
//				if(j == B-1)
//					break;
//				else
//					j += 1;
//			}	
//			else{
//				if(i == A-1)
//					break;
//				else
//					i += 1;
//			}
//			
//		}
		System.out.println(result);
		
	}

}
