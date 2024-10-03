import java.io.*;
import java.util.*;

public class Main {

	static String s,k,input;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(true) {
			input = br.readLine();
			if(input ==null) break;
			st = new StringTokenizer(input);
			k = st.nextToken(); s = st.nextToken();
			if(check())System.out.println("Yes");
			else System.out.println("No");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean check() {
		int sidx = 0;int kidx = 0;
		while(sidx!=s.length()) {
			if(k.charAt(kidx)==s.charAt(sidx)) kidx++;
			if(kidx==k.length())return true;
			sidx++;
		}
		return false;
	}
}