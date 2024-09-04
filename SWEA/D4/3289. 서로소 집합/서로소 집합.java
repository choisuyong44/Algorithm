import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC= Integer.parseInt(br.readLine());
		int N,M;
		
		for(int T = 1;T<TC+1;T++) {
			sb.append("#").append(T).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 0은 없다.
			parent = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				parent[i] =i;
			}
			
			int a,b;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken()) ==0) {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					union(a,b);
				}
				
				else {
					a = Integer.parseInt(st.nextToken());
					b = Integer.parseInt(st.nextToken());
					
					if(find(a) == find(b)) sb.append(1);
					else sb.append(0);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x<y) parent[y] = x;
		else parent[x] =y;
	}
	
	public static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
}