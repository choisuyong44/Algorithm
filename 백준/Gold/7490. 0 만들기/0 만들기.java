import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static boolean[] visited;
	static char[] c = {' ','+','-'}; 
	static char[] ans;
	static Stack<Integer> s = new Stack<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N-1];
			ans = new char[N-1];
			dfs(0);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(int depth) {
		if(depth==N-1) {
			if(isZero()) {;
				for(int i =0;i<N-1;i++) {
					sb.append(i+1);
					sb.append(ans[i]);
				}
				sb.append(N).append("\n");
			}
			return;
		}
		
		for(int i =0;i<3;i++) {
			ans[depth] = c[i];
			dfs(depth+1);
		}
	}
	
	static boolean isZero() {
		s.clear();
		s.add(1);
		for(int i =0;i<N-1;i++) {
			if(ans[i] == '+') {
				s.add(i+2);
			}
			else if (ans[i] == '-'){
				s.add(-1*(i+2));
			}
			else {
				s.add(link(s.pop(),i+2));
			}
		}
		
		int sum = 0;
		while(!s.isEmpty()) {
			sum += s.pop();
		}
		
		if(sum ==0) return true;
		return false;
	}
	
	static int link(int a, int b) {
		if(a>0) return a*10+b;
		return a*10-b;
	}
}