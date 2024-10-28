import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static final int L = -1;
	static final int D = 1;
	static int d = 0,time=0;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	static int N,K,C,nr,nc;
	static int[][] map;
	static int[][] bam;
	static int SZ;
	static List<int[]> change = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		input();
		bam[0][0] = bam[0][1] = SZ = 1;
		simulation();
		System.out.println(time);
	}
	
	public static void simulation() {
		while(true) {
			time++;
			
			// 헤드 한 칸 앞으로
			nr = bam[0][0] +dr[d];
			nc = bam[0][1] +dc[d];
			
			// 범위 초과
			if(nr<=0 || nr>N || nc<=0 || nc>N) return;
			
			// 자신과 부딪히는 경우
			for(int i =1;i<SZ;i++) {
				if(bam[i][0]==nr && bam[i][1]==nc) return;
			}
			
			// 사과를 찾았다.
			if(map[nr][nc]==1) {
				SZ++;
				map[nr][nc] =0;
			}
			
			for (int i = SZ - 1; i > 0; i--) {
			    bam[i][0] = bam[i - 1][0];
			    bam[i][1] = bam[i - 1][1];
			}
			
			bam[0][0] = nr; bam[0][1] = nc;
			
			// 방향을 바꾼다
			for(int[] k : change) {
				if(k[0] == time) {
					if(k[1]==D) d = (d+1)%4;
					else d = (4+d-1)%4;
				}
			}
		}
	}
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		for(int i =0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		C = Integer.parseInt(br.readLine());
		for(int i=0;i<C;i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			if(st.nextToken().equals("D")) change.add(new int[] {time,D});
			else change.add(new int[] {time,L});
		}	
		
		bam = new int[K+1][2];
	}
}