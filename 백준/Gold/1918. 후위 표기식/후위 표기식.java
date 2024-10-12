import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> s  = new Stack<>();
		String tmp = br.readLine();
		char[] c = tmp.toCharArray();

		for(int i =0;i<c.length;i++) {
			//  '('
			if(c[i]=='(') {
				s.push(c[i]);
			}
			
			// ')'
			else if(c[i]==')') {
				char k = s.pop();
				while(k !='(') {
					System.out.print(k);
					k = s.pop();
				}
			}
			
			// + -
			else if(c[i]== '+'|| c[i]=='-') {
				while(!s.empty() && s.peek()!='(') System.out.print(s.pop());
				s.push(c[i]);
			}
			
			// * /
			else if(c[i]== '*' || c[i] == '/') {
				while(!s.empty()&&(s.peek()=='*' || s.peek()=='/')) {
					System.out.print(s.pop());
				}
				s.push(c[i]);
			}
			
			// 숫자
			else System.out.print(c[i]);
		}
		
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}