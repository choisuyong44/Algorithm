import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	

	static boolean flag = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		dfs(s,t);
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void dfs(String s, String t) {
		if(s.length()==t.length()) {
			if(s.equals(t)) flag= true;
			return;
		}
		
		if(t.length()==0) return;
		if(t.charAt(0)=='B') {
			String sub = t.substring(1);
			StringBuilder sb = new StringBuilder(sub);
			String str = sb.reverse().toString();
			dfs(s,str);
		}
		
		if(t.charAt(t.length()-1) =='A') {
			dfs(s,t.substring(0, t.length()-1));
		}
		
	
	}
}