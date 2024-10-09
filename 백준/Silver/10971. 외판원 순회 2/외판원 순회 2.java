import java.io.*;
import java.util.*;

public class Main {

	static int ans,sum;
	static int N;
	static int[][] map;
	static int[] path;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N]; path = new int[N];
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	
	public static void perm(int depth) {
		if(depth==N) {
			if(!calculateCost()) return;
			ans = Math.min(ans, sum);
			return;
		}
		
		for(int i =0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				path[depth] = i;
				perm(depth+1);
				visited[i] = false;
			}
		}
	}
	
	public static boolean calculateCost() {
		sum = 0;
		for(int i =0;i<N-1;i++) {
			if(map[path[i]][path[i+1]] ==0) return false;
			sum += map[path[i]][path[i+1]];
		}
		if(map[path[N-1]][path[0]] ==0) return false;
		sum += map[path[N-1]][path[0]];
		return true;
	}
}