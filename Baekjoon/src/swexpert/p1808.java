package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Num implements Comparable<Num>{
	long val;
	int count;
	
	public Num(long val, int count) {
		this.val = val;
		this.count = count;
	}

	@Override
	public int compareTo(Num o) {
		if(this.val == o.val)
			return this.count - o.count;
		return (this.val - o.val > 0) ? 1 : -1;
	}
	
}

public class p1808 {
	
	static int X, answer;
	static ArrayList<Num> flist;
	static ArrayList<Num> slist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			answer = -1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			flist = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				if(st.nextToken().charAt(0) == '1')
					flist.add(new Num(i, 1));
			}
			X = Integer.parseInt(br.readLine());
			slist = new ArrayList<>();
			calcElemList();
			BFS();
			System.out.println("#"+t+" "+answer);
		}
	}
	
	public static void calcElemList(){
		PriorityQueue<Num> pq = new PriorityQueue<>();
		visited = new boolean[X+1];
		pq.addAll(flist);
		while(!pq.isEmpty()){
			Num p = pq.poll();
			if(p.val == 0)
				continue;
			if(p.val <= X){
				if(!visited[(int)p.val]){
					visited[(int)p.val] = true;
					slist.add(new Num(p.val, p.count));
				}
				for(Num e : flist){
					if(Integer.parseInt(p.val + "" + e.val) <= X)
						pq.add(new Num(Integer.parseInt(p.val + "" + e.val), p.count + 1));
				}
			}
		}
	}
	
	public static void BFS(){
		PriorityQueue<Num> queue = new PriorityQueue<>();
		queue.addAll(slist);
		while(!queue.isEmpty()){
			Num ob = queue.poll();
			if(ob.val == X){
				answer = ob.count + 1;
				return;
			}
			for(Num d : slist){
				if(ob.val * d.val > X)
					break;
				else{
					if(!visited[(int)(ob.val * d.val)]){
						visited[(int)(ob.val * d.val)] = true;
						queue.add(new Num(ob.val * d.val, ob.count + d.count + 1));
					}
				}
			}
		}
	}
}

// 92 -1 => 9
// 73 -1 => 7 (1999 * 9 = 17991)
