import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	/*
	 * djikstra O((V+E) logV) * N 개 -> N<=200 이므로 가능
	 * 1000 이하니까 200*1000 이므로 int
	 */
	final static int INF = 200*1000;
	static int N,M,A,B,W;
	static int[][] map;
	static int[][] ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N+1][N+1];
		ans = new int[N+1][N+1];
		
		// map 초기화
		for(int i =1;i<N+1;i++) {
			Arrays.fill(map[i], INF);
		}
		
		for(int i =1;i<N+1;i++) {
			for(int j =1 ;j<N+1;j++) {
				ans[i][j] = j;
			}
		}
		
		// M 입력 
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			W = Math.min(W, map[A][B]);
			map[A][B] = W;
			map[B][A] = W;
		}
		
		// 플로이드 워샬
		for(int k = 1;k<N+1;k++) {
			for(int i = 1;i<N+1;i++) {
				for(int j = 1; j<N+1;j++) {
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
						ans[i][j] = ans[i][k];
					}
				}
			}
		}
	
		for(int i = 1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				if(i==j) {
					sb.append("- ");
				}
				else sb.append(ans[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}