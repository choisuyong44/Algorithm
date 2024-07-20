import java.io.*;
import java.util.*;

public class Main {

	public static long gcd(long p,long q) {
		if(p%q==0) 
			return q;
		return gcd(q,p%q);
	}
	
	public static void main(String[] args) throws IOException{
		
		
		/*
		 * 입력 : 10^3 ~ 10^8 ..
		 * Integer 2* 10^9 까지 가능 -> LongType
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Long A = Long.parseLong(st.nextToken());
		Long B = Long.parseLong(st.nextToken());
		
		Long k = gcd(A,B);
		
		System.out.println(A*B/k);
	}

}