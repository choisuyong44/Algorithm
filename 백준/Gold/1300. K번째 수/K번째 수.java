import java.util.Scanner;

public class Main {
	static long N,K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		K = sc.nextLong();	
		binarySearch();
	}
	
	public static void binarySearch() {
		long min =1; long max = K+1; long mid,cnt;
		while(min<max) {
			mid = (min+max)/2;
			cnt = 0;
			for(int i =1;i<=N;i++) {
				cnt+= Math.min(mid/i, N);
			}
			if(cnt < K) {
				min = mid+1;
			}
			else {
				max = mid;
			}
		}
		System.out.println(min);
	}
}