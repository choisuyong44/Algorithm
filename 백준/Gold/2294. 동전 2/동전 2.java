import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 99999;
	static int n,k;
	static int[] dp;
	static List<Integer> coin;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		dp = new int[10001];
		Arrays.fill(dp, INF);
		
		coin = new ArrayList<Integer>();
		for(int i =0;i<n;i++) {
			int tmp = sc.nextInt();
			if(tmp <= k) {
				coin.add(tmp);
				dp[tmp] = 1;
			}
		}
		
		for(int i =1;i<10001;i++) {
			for(int j = 0;j<coin.size();j++) {
				if(i - coin.get(j) >= 0 && dp[i-coin.get(j)]!=INF) {
					dp[i] = Math.min(dp[i], dp[i-coin.get(j)]+1);
				}
			}
		}
		
		if(dp[k]==INF) System.out.println(-1);
		else System.out.println(dp[k]);
	}
}