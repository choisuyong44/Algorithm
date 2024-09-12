import java.io.*;
import java.util.*;

/*
 * 알고리즘 : 유니온 파인드
 */

public class Main {

	static int V, E;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		out : for (int T = 1; T < TC + 1; T++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			// V 생성
			parent = new int[V+1];
			for(int i =1;i<=V;i++) {
				parent[i] = i;
			}
			
			// E 입력
			int cnt =0;
			int ans =0;
			for(int i =0;i<E;i++) {		
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if(find(A)!=find(B)) {
					cnt++;
					union(A,B);
					
					if(checkLinkedAll() && ans ==0) {
						ans = cnt;
					}
				}
			}
			
			System.out.println(ans);
		}
	}
	
	public static boolean checkLinkedAll() {
		int k = find(1);
		for(int i= 1;i<=V;i++) {
			if(find(i)!=k) return false;
		}
		return true;
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x,int y) {
		x = find(x);
		y = find(y);
		if(x<y) parent[y] =x;
		else parent[x] =y;
	}
}