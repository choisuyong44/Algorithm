import java.io.*;
import java.util.*;

public class Solution {

	static class Processor{
		int r;
		int c;
		
		public Processor(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int cnt;
	static int min_link;
	static int max_core;
	static int core;
	static int N;
	static int[][] map;
	static List<Processor> list;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	/*
	 * empty : 0
	 * processor : 1
	 * link : 2
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1; T<TC+1;T++) {
			N = Integer.parseInt(br.readLine());
			
			core = 0;
			map = new int[N][N];
			list = new ArrayList<Processor>();
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					// process가 존재하는 경우
					if(map[i][j]==1) {
						// 0이나 N-1인 경우 default core
						if(i ==0 || i ==N-1 || j ==0 || j == N-1) {
							core++;
							continue;
						}
						
						// 아닌 경우는 부분 조합을 통해 탐색
						list.add(new Processor(i, j));
					}
				}
			}
			
			min_link =Integer.MAX_VALUE;
			max_core =0;
			
			powerSet(0,core,0);
			
			sb.append("#").append(T).append(" ").append(min_link).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void powerSet(int depth, int core,int line) {
		if(depth == list.size()) {
			
			// core의 갯수가 더 많은 경우
			// 최소 link는 현재의 line
			if(max_core < core) {
				max_core = core;
				min_link = line;
				return;
			}
			
			// core의 갯수가 같은 경우
			// 최소 link는 현재의 line
			if(max_core == core) {
				min_link = Math.min(min_link, line);
				return;
			}
			
			// 그 외의 경우는 필요 없음
			return;
		}
		
		// 연결하는 경우
		for(int d=0;d<4;d++) {
			Processor k = list.get(depth);
			
			if(canConnect(k.r, k.c, d)) {
				
				// 연결 시 line의 길이 check
				cnt = 0;
				// 연결
				link(k.r,k.c,d,2);
				powerSet(depth+1,core+1,line+cnt);
				// 해제
				link(k.r,k.c,d,0);
			}
		}
		
		// 연결하지 않는 경우
		powerSet(depth+1,core,line);
	}
	
	public static boolean canConnect(int r, int c, int d) {
		
		// 현재 프로세스 다음부터 탐색
		int nr = r+dr[d];
		int nc = c+dc[d];
		
		// 범위 체크
		while(nr >=0 && nr<N &&nc>=0 && nc<N) {
			if(map[nr][nc]!=0) return false;
			
			nr = nr+dr[d];
			nc = nc+dc[d];
		}
		
		return true;
	}
	
	public static void link(int r,int c, int d,int v) {
		// 나 다음부터 연결을 해야함
		int nr = r+dr[d];
		int nc = c+dc[d];
		
		while(nr >=0 && nr<N &&nc>=0 && nc<N) {
			cnt++;
			map[nr][nc] = v;

			nr = nr+dr[d];
			nc = nc+dc[d];
		}
	}
}