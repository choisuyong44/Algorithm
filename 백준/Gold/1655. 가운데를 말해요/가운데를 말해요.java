import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

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
			
            // 최대 힙(min)과 최소 힙(max)에 값 분배
            if (min.isEmpty() || k <= min.peek()) {
                min.add(k);
            } else {
                max.add(k);
            }

            // 두 큐의 크기 균형 유지
            if (min.size() > max.size() + 1) {
                max.add(min.poll());
            } else if (max.size() > min.size()) {
                min.add(max.poll());
            }
			
			sb.append(min.peek()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}