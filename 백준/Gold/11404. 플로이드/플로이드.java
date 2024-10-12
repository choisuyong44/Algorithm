import java.util.*;
import java.io.*;
	
public class Main {

	static int N,M,A,B,W;
	static int INF = 10_000_000;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i =1;i<N+1;i++) {
			Arrays.fill(map[i], INF);
			map[i][i] =0;
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			W = Math.min(W,map[A][B]);
			map[A][B] = W;
		}
		
		for(int k = 1;k<N+1;k++) {
			for(int i =1;i<N+1;i++) {
				for(int j = 1;j<N+1;j++) {
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		
		for(int i =1;i<N+1;i++) {
			for(int j = 1;j<N+1;j++) {
				if(i==j) sb.append("0 ");
				else if(map[i][j]>=INF) sb.append("0 ");
				else sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}