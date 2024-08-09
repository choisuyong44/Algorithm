import java.io.*;
import java.util.*;

public class Main {

	static int[] map = new int[101];
	static int[] visit = new int[101];

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int ladder = Integer.parseInt(st.nextToken());
		int snake = Integer.parseInt(st.nextToken());

		for (int i = 1; i < 101; i++) {
			map[i] = i;
		}

		int start;
		int end;
		for (int i = 0; i < ladder + snake; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start] = end;
		}

		bfs(1);
	}

	public static void bfs(int idx) {

		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.offer(idx);
		visit[idx] = 0;
		
		int k;
		
		while(!queue.isEmpty()) {
			
			k = queue.poll();
			
			for(int i =1;i<=6;i++) {
				
				if(visit[map[k+i]] == 0) {
					visit[map[k+i]] = visit[map[k]]+1;
					queue.offer(map[k+i]);
				}
				
				if(map[k+i]== 100) {
					System.out.println(visit[100]);
					return;
				}
			}
		}
		
	}
}