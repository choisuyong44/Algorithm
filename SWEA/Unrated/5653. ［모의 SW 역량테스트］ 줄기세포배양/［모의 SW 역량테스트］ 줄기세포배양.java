import java.io.*;
import java.util.*;

public class Solution {

	static PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
		@Override
		public int compare(Cell o1, Cell o2) {
			return o2.ready - o1.ready;
		};
	});

	static List<Cell> list;
	
	static boolean[][] visit;
	
	static int N;
	static int M;
	static int K;
	
	static final int DEAD = 0;
	static final int ACTIVE = 1;
	static final int DEACTIVE = 2;
	
	static final int[] dr = {-1,1,0,0};
	static final int[] dc = {0,0,-1,1};
	
	static int nr,nc;
	static Cell temp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int T = 1; T< TC+1;T++) {
			pq.clear();
			st = new StringTokenizer(br.readLine());
			
			list = new ArrayList<Cell>();
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			int ROW = N+(K*2);
			int COL = M+(K*2);
			visit = new boolean[ROW][COL];
			int cell;
			
			for(int i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<M;j++) {
					cell = Integer.parseInt(st.nextToken());
					if(cell > 0) {  
						// 방문 처리
						visit[i+K][j+K] = true;
						// 추가
						list.add(new Cell((i+K),(j+K),cell));
					}
				}
			}
			
			growth();
			
			// list에서 돌면서 갯수 세기
			int cnt =0;
			for(Cell c : list) {
				if(c.status == DEACTIVE || c.status ==ACTIVE) {
					cnt++;
				}
			}

			sb.append("#" +T + " " + cnt +"\n");
		}
		System.out.println(sb.toString());
	}

	public static void growth() {
		while(K-- >= 0) {
			
			while(!pq.isEmpty()) {
				Cell tmp = pq.poll();
				
				// 넣기
				for (int d =0;d<4;d++) {
					
					nr = tmp.r + dr[d];
					nc = tmp.c + dc[d];
					
					if(visit[nr][nc] == false) {
						list.add(new Cell(nr,nc,tmp.ready));
						visit[nr][nc] = true;
					}
				}
			}
			
			for(Cell c : list) {
				c.next();
			}
		}
	}
	
	static class Cell {
		int r;
		int c;
		
		// DEACTIVE 대기 시간
		int ready;
		int aliveTime;
		
		// DEACTIVE
		int status;
		
		// 살아있는 시간을 누적시켜서 더할 예정
		public Cell(int row, int col, int ready) {
			this.r = row;
			this.c = col;
			this.ready = ready;
			this.aliveTime = ready*2;
			this.status = DEACTIVE;
		}
		
		public void next() {
			if(status ==DEAD) {
				return;
			}
			
			if(this.aliveTime == this.ready && this.status == DEACTIVE) {
				aliveTime--;
				status = ACTIVE;
				pq.add(this);
				return;
			}
			
			if(this.aliveTime == 0 && this.status == ACTIVE) {
				status = DEAD;
				return;
			}
			
			aliveTime--;
		}
	}
}