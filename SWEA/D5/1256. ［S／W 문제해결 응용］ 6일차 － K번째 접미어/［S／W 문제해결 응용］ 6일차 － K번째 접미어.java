import java.io.*;
import java.util.*;

public class Solution {

	static StringBuilder sb = new StringBuilder();
	static String s;
	static String[] str; 
	static int K;


	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		none : for(int T = 1;T<TC+1;T++) {
		
			// 2. 입력
			K = sc.nextInt();
			s = sc.next();
			int sz = s.length();
			
			if(sz <K) {
				System.out.println("#"+T+" none");
				continue none;
			}
			
			str = new String[sz];
			
			for(int i =0;i<s.length();i++) {
				str[i] =s.substring(i);
			}
		
			Arrays.sort(str);
			
			System.out.println("#"+T+" "+str[K-1]);
		}
		System.out.println(sb.toString());
	}
}