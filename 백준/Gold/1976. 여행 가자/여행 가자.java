import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] conn;
	static int[] path;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		input();

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (conn[i].contains(j)) {
					union(i,j);
				}
			}
		}
		
		int k = find(path[0]);
		for(int i =0;i<M;i++) {
			if(k!=find(path[i])) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y)
			parent[x] = y;
		else
			parent[y] = x;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		conn = new List[N + 1];
		parent = new int[N + 1];
		path = new int[M];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		for (int i = 1; i < N + 1; i++) {
			conn[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				if (st.nextToken().equals("1"))
					conn[i].add(j);
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			path[i] = Integer.parseInt(st.nextToken());
		}
	}
}