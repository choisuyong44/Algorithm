import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		BigInteger num = new BigInteger("2");
		sb.append(num.pow(N).subtract(new BigInteger("1"))).append("\n");
		
		if(N<=20)hanoi(N,1,2,3);	
		
		System.out.println(sb.toString());
	}
	
	public static void hanoi(int n , int from, int tmp, int to) {
		if(n== 1) {
			sb.append(from + " " + to).append("\n");
			return;
		}
		
		hanoi(n-1,from,to,tmp);
		sb.append(from + " " + to).append("\n");
		hanoi(n-1,tmp,from,to);
	}
}