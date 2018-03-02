import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/*
2
GCF
ACDEB
*/
public class p1339 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		String str;
		String[] strArr = new String[N];
		HashMap<Character, Integer> map = new HashMap<>(); 
		for (int i = 0; i < N; i++){
			str = br.readLine();
			strArr[i] = str;
			for (int j = 0; j < str.length(); j++) {
				if(map.get(str.charAt(j)) == null)
					map.put(str.charAt(j), (int) Math.pow(10, str.length() - j - 1));
				else
					map.put(str.charAt(j), map.get(str.charAt(j)) + (int) Math.pow(10, str.length() - j - 1));
			}
		}
		
		Integer[] arr = map.values().toArray(new Integer[map.values().size()]);
		Arrays.sort(arr);
		int st = 9;
		for (int i = arr.length - 1; i >= 0; i--) {
			for(char c : map.keySet()){
				if(map.get(c) == arr[i]){
					for (int j = 0; j < strArr.length; j++)
						strArr[j] = strArr[j].replace(c+"", st+"");
					st -= 1;
					map.put(c, 0);
					break;
				}
			}
		}

		for (int i = 0; i < strArr.length; i++) {
			sum += Integer.parseInt(strArr[i]);
		}
		System.out.println(sum);
	}

}
