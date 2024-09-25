import java.io.*;
import java.util.*;

public class Main {

	
	static int N,M;
	static final int INF = 999;
	static int[][] d;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		d = new int[N+1][N+1];
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=N;j++) {
				if(i==j) d[i][j] =d[j][i] =0;
				else d[i][j] = d[j][i] = INF;
			}
		}
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			d[A][B] = d[B][A] = 1;
		}
		
		for(int k =1;k<=N;k++) {
			for(int i =1;i<=N;i++) {
				for(int j = 1;j<=N;j++) {
					d[i][j] = Math.min(d[i][j],d[i][k]+d[k][j]);
				}
			}
		}
		
		long min = Integer.MAX_VALUE; long sum; int idx =-1;
		for(int i =1;i<=N;i++) {
			sum = 0;
			
			for(int j = 1;j<=N;j++) {
				sum += d[i][j];
			}
			
			if(min > sum) {
				min = sum;
				idx = i;
			}
		}
		
		System.out.println(idx);
	}
}