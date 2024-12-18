import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] buildings;
	static int[][] ans;
	static Stack<int[]> stack;
	public static void main(String[] args) throws IOException{
		StringBuilder sb = new StringBuilder();
		input();
		forward();
		backward();
		for(int i =1;i<N+1;i++) {
			if(ans[i][0]==0) {
				sb.append(0).append("\n");
			}
			else {
				sb.append(ans[i][0]).append(" ").append(ans[i][1]).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void  forward() {
		stack = new Stack<int[]>();
		for(int i =1;i<N+1;i++) {
			// stack이 비어있는 경우 넣기
			if(stack.isEmpty()) stack.push(new int[] {i,buildings[i]});
			
			else {
				while(!stack.isEmpty() && stack.peek()[1] <= buildings[i]) {
					stack.pop();
				}
				if(!stack.isEmpty()) {
					ans[i][1] = stack.peek()[0];
					ans[i][0] += stack.size();
				}
				stack.push(new int[] {i,buildings[i]});
			}
		}
	}
	
	public static void  backward() {
		stack = new Stack<int[]>();
		for(int i = N; i>0;i--) {
			// stack이 비어있는 경우 넣기
			if(stack.isEmpty()) stack.push(new int[] {i,buildings[i]});
			else {
				while(!stack.isEmpty() &&stack.peek()[1] <= buildings[i]) {
					stack.pop();
				}
				if(!stack.isEmpty()) {
					if(ans[i][0] ==0) ans[i][1] = stack.peek()[0];
					else if(Math.abs(ans[i][1]-i) > Math.abs(stack.peek()[0]-i)) {
						ans[i][1] = stack.peek()[0];
					}
					ans[i][0] += stack.size();
				}
				stack.push(new int[] {i,buildings[i]});
			}
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		buildings = new int[N+1];
		for(int i =1;i<N+1;i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}
		ans = new int[N+1][2];
	}
}