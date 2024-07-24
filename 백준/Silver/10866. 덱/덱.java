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
			
			//push_front X: 정수 X를 덱의 앞에 넣는다.
			if(s.equals("push_front")) {
				n = Integer.parseInt(st.nextToken());
				dq.offerFirst(n);
			}
			
			//push_back X: 정수 X를 덱의 뒤에 넣는다.
			else if(s.equals("push_back")) {
				n = Integer.parseInt(st.nextToken());
				dq.offerLast(n);
			}
			
			// pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			else if(s.equals("pop_front")){
				if(dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.removeFirst());
				}
			}
			
			
			// pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			else if(s.equals("pop_back")){
				if(dq.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(dq.removeLast());
				}
			}
			
			// size: 덱에 들어있는 정수의 개수를 출력한다.
			else if(s.equals("size")) {
				System.out.println(dq.size());
			}
			
			// empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
			else if(s.equals("empty")) {
				if(dq.isEmpty())System.out.println(1);
				else System.out.println(0);
			}
			
			//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			else if(s.equals("front")) {
				if(dq.isEmpty())System.out.println(-1);
				else {
					System.out.println(dq.peekFirst());
				}
			}
			
			//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
			else if(s.equals("back")) {
				if(dq.isEmpty())System.out.println(-1);
				else {
					System.out.println(dq.peekLast());
				}
			}
		}
	}
}