import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder sb = new StringBuilder();
	
	static int[] before = new int[1000001];
	static int[] time = new int[10000001];
	
 	static Queue<Integer> q = new LinkedList<Integer>();
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		bfs();

		Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(before[index]);
            index = before[index];
        }

        sb.append(time[K] - 1 + "\n");
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());
	}

	public static void bfs() {
		q.add(N);
	    time[N] = 1;
		
		while(!q.isEmpty()) {
			
			int k =q.poll();
			
			if(k==K) return;
			
            for (int i=0; i<3; i++) {
                int next;

                if (i == 0)         next = k + 1;
                else if (i == 1)    next = k - 1;
                else                next = k * 2;

                if (next < 0 || next > 100000) continue;

                // 방문 하지 않은 경우만
                if (time[next] == 0) {
                    q.add(next);
                    time[next] = time[k] + 1;
                    before[next] = k;
                }
            }
		}
	}
}