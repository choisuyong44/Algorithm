import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] nums;
	static boolean[] visited;
	static boolean[] already;
	
	static List<Integer> tmp;
	static PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> ans = new PriorityQueue<Integer>();
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		nums = new int[N+1];
		already = new boolean[N+1];
		
		for(int i=1;i<N+1;i++) {
			nums[i] = sc.nextInt();
		}
		
		out : for(int i =1;i<N+1;i++) {
			if(already[i]) continue;
		
			pq1.clear();
			pq2.clear();	
			tmp = new ArrayList<Integer>();
		
			visited = new boolean[N+1];
			dfs(i);
			
			if(pq1.size() != pq2.size()) continue;
			
			int pqSZ = pq1.size();
			for(int j = 0;j<pqSZ;j++) {
				tmp.add(pq1.poll());
				if(tmp.get(j)!= pq2.poll()) continue out ;
			}
			
			for(int k = 0;k<tmp.size();k++) {
				ans.offer(tmp.get(k));
				already[tmp.get(k)]= true;
			}
		}
		
		System.out.println(ans.size());
		while(!ans.isEmpty()) {
			System.out.println(ans.poll());
		}
	}
	
	public static void dfs(int start) {
		if(visited[start]) return;		
		visited[start] = true;
		
		pq1.add(start);
		pq2.add(nums[start]);
		
		dfs(nums[start]);
	}
}