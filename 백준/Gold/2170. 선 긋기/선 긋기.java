import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0]-o2[0];
		}
	});
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		int a,b;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			pq.add(new int[] {a,b});
		}
		
		int ans =0;
		int[] k = pq.poll();
		int start = k[0]; int end = k[1];
		while(!pq.isEmpty()) {
			k = pq.poll();
			if(k[0] > end) {
				ans += end-start;
				start = k[0];
			}
			end = Math.max(end, k[1]);
		}		
		
		ans += end-start;
		
		System.out.println(ans);
	}
}