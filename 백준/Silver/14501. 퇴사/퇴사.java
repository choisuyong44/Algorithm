import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int days[][];
	static int max_value;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		days = new int[N+1][2];
		
		for(int i =1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			days[i][0] = Integer.parseInt(st.nextToken());
			days[i][1] = Integer.parseInt(st.nextToken());
			// System.out.println(days[i][0] + " " +days[i][1]);
		}
		
		max_value = 0;

		dfs(1,0);
		
		
		System.out.println(max_value);
	}
	
	public static void dfs(int day,int sum) {
		// day 가 N이 넘는 경우
		// 더 이상 일을 할 수 없으므로 최댓값 return
		if(day> N) {
			if(day-1 == N) {
				max_value = Math.max(sum,max_value);
			}
			return;
		}
		
		dfs(day + days[day][0], sum + days[day][1]);
		dfs(day+1,sum);
	}
}