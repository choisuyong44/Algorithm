import java.io.*;
import java.util.*;

public class Main {
	static int N, k;
	static PriorityQueue<Integer> min = new PriorityQueue<Integer>((o1, o2) -> {
		return o2 - o1;
	});
	static PriorityQueue<Integer> max = new PriorityQueue<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			k = Integer.parseInt(br.readLine());
            if (min.isEmpty() || k <= min.peek()) {
                min.add(k);
            } 
            else {
                max.add(k);
            }
            
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            } 
            else if (max.size() > min.size()) {
                min.add(max.poll());
            }
			sb.append(min.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}