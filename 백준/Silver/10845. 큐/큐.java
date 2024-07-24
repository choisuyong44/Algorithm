import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> dq= new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		String s; int n;
		for (int i =0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			
			if(s.equals("push")) {
				n = Integer.parseInt(st.nextToken());
				dq.offer(n);
			}
			
			else if (s.equals("pop")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.removeFirst());
			}
			
			else if (s.equals("size")){
				System.out.println(dq.size());
			}
			
			else if (s.equals("empty")) {
				if(dq.isEmpty()) {
					System.out.println(1);
					continue;
				}
				System.out.println(0);
			}
			
			else if (s.equals("front")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.peekFirst());
			}
			
			else if (s.equals("back")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
					continue;
				}
				System.out.println(dq.peekLast());
			}
		}
	}
}