import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String target = br.readLine();
		int targetSize = target.length();
		
		Stack<Character> st = new Stack<Character>();
		for(int i =0;i<str.length();i++) {
			st.push(str.charAt(i));
			
			if(st.size()>=targetSize) {
				boolean flag = true;
				
				for(int j =0;j<targetSize;j++) {
					if(st.get(st.size()-targetSize+j) != target.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0;j<targetSize;j++) {
						st.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		if(sb.length()==0)System.out.println("FRULA");
		else System.out.println(sb.reverse().toString());
	}
}