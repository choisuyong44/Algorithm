import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Point implements Comparable<Point>{
		int x;
		int cost;
		public Point(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost-o.cost;
		}
	}
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int K = sc.nextInt();
		if(X==K) {
			System.out.println(0);
			return;
		}
		if(X==0) {
			pq.add(new Point(1,1));
		}
		else pq.add(new Point(X,0));
		visited = new boolean[100_001];
		while (!pq.isEmpty()) {
			
			Point p = pq.poll();
			visited[p.x]=true;
			if(p.x==K) {
				System.out.println(p.cost);
				return;
			}
			if(p.x > 0 && !visited[p.x-1]) pq.add(new Point(p.x-1, p.cost+1));
			if (p.x <100_000 && !visited[p.x+1])pq.add(new Point(p.x+1, p.cost+1));
			if (p.x > 0 && p.x*2 <=100_000 && !visited[p.x*2])pq.add(new Point(p.x*2, p.cost));
		}
	}
}