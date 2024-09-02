import java.io.*;
import java.util.*;

public class Solution {

	static int[] parent;
	static int N,M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T=1;T<TC+1;T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int i=1;i<N+1;i++) {
				parent[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			
			Set<Integer> set = new HashSet<>();
			for(int i=1;i<N+1;i++) {
				set.add(find(i));
			}

			sb.append("#").append(T).append(" ").append(set.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean union(int x, int y) {
		x = find(x); //x의 부모노드 찾기
		y = find(y); //y의 부모노드 찾기
	    
		// 이미 같은 그래프에 속해있을 때 false 반환
		if(x == y) return false;
		
		if(x <= y) parent[y] = x;
		else parent[x] = y;
		return true;
	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
}