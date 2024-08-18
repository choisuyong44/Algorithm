import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int cnt;
	static String s;
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		
		for(int T = 1; T<TC+1;T++) {
			cnt =0;
			s = br.readLine();
			countAlpha();
			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void countAlpha() {
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == 'a'+i) {
				cnt++;
			}
			else {
				break;
			}
		}
	}
}