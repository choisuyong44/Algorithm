import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		int N, M;

		for (int T = 1; T < TC + 1; T++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// make-set
			parent = new int[N+1];
			for(int i=1;i<=N;i++) {
				parent[i] =i;
			}
			
			int a,b;
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				union(a,b);
			}
			
			// find 로 찾아야함 아직 리뉴얼이 모두 된 것이 아님
			int cnt =0;
			for(int i=1;i<=N;i++) {
				if(find(i)== i) cnt++;
			}
			
			sb.append("#").append(T).append(" ").append(cnt).append("\n");
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