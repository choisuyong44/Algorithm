import java.util.Scanner;

public class Main {

	static int[] minus;
	static int[] plus;
	
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		minus = new int[1_000_001];
		plus = new int[1_000_001];
		minus[0] = plus[0] = 0;
		minus[1] = plus[1] = 1;
	
		// plus -> dp[n] = dp[n-1]+dp[n-2];
		for(int i =2;i<1_000_001;i++) {
			plus[i] = (plus[i-1]+plus[i-2])%1000_000_000;
		}
		// minus ->dp[n] = dp[n-2]-dp[n-1];
		for(int i = 2;i<1_000_001;i++) {
			minus[i] = (minus[i-2]-minus[i-1])%1000_000_000;
		}
		
		if(n>=0) {
			if(plus[n]>0) {
				System.out.println(1);
			}
			else if(plus[n]==0) {
				System.out.println(0);
			}
			else {
				System.out.println(-1);
			}
			System.out.println(plus[n]);
		}

		else {
			n = Math.abs(n);
			if(minus[n]>0) {
				System.out.println(1);
			}
			else if(minus[n]==0) {
				System.out.println(0);
			}
			else {
				System.out.println(-1);
			}
			System.out.println(Math.abs(minus[n]));
		}
	}
}