import java.io.*;
import java.util.*;

import javax.print.attribute.IntegerSyntax;

public class Main {

	static boolean[] S;
	static int M,x; 
	static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		S = new boolean[21];
		M = Integer.parseInt(br.readLine());
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			
			if(str.charAt(0)=='a') {
				// add
				if(str.charAt(1)=='d') {
					x = Integer.parseInt(st.nextToken());
					S[x] = true;
				}
				// all
				else {
					Arrays.fill(S, true);
				}
			}
			
			// check
			else if(str.charAt(0)=='c') {
				x = Integer.parseInt(st.nextToken());
				if(S[x])sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
			
			// empty
			else if(str.charAt(0)=='e') {
				Arrays.fill(S, false);
			}
			
			// toggle
			else if(str.charAt(0)=='t') {
				x = Integer.parseInt(st.nextToken());
				S[x] = !S[x];
			}
			
			// remove
			else {
				x = Integer.parseInt(st.nextToken());
				S[x] = false;
			}
		}	
		System.out.println(sb.toString());
	}
}