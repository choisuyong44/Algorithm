import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean findAns;
	static int cnt =0;
	static List<Integer> ans = new ArrayList<>();
	static int N,K;
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		N = sc.nextInt(); K = sc.nextInt();
		
		int[] dp = new int[11];
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
		for(int i =4;i<11;i++) {
			dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		if(K >dp[N]) {
			System.out.println(-1);
			return;
		}
		
		dfs(0);
	}
	
	public static void dfs(int sum) {
		if (findAns || N < sum) return;
		
		// 합이 N인 경우
		if(N == sum) {
			cnt++;
			if(cnt==K) {
				for(int i =0;i<ans.size()-1;i++) {
					System.out.print(ans.get(i)+"+");
				}
				System.out.print(ans.get(ans.size()-1));
			}
		}
		
		// dfs
		for(int i = 1;i<=3;i++) {
			ans.add(i);
			sum +=i;
			dfs(sum);
			sum -=i;
			ans.remove(ans.size()-1);
		}
	}
}