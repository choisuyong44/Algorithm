import java.io.*;
import java.util.*;

public class Main {

	public static int gcd(int p,int q) {
		while(p%q!=0) {
			int tmp = p;
			p = q;
			q = tmp%q;
		}
		return q;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
				
		int a; int b;int sum =0; int k = 0;
		
		for(int i =0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			sum = a*b;
			k =gcd(a,b);
			System.out.println(a*b/k);
		}
	}
}