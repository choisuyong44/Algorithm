import java.io.*;
import java.util.*;

public class Main {

	static Queue<Pos> q = new LinkedList<Pos>();
	
	static int[] dr= {-1,-1,0,1,1,1,0,-1};
	static int[] dc= {0,1,1,1,0,-1,-1,-1};
	
	static int ROW,COL;
	static int[][] map;
	static boolean[][] visit;
	
	static int cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 너비(COL) 높이(ROW)
		COL = Integer.parseInt(st.nextToken());
		ROW = Integer.parseInt(st.nextToken());
		while(ROW !=0 && COL !=0) {
			
			// 맵 생성 및 초기화
			map = new int[ROW][COL];
			visit = new boolean[ROW][COL];
			
			for(int r= 0;r<ROW;r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0;c<COL;c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// for-for BFS -- cnt
			cnt = 0;
			for(int r =0;r<ROW;r++) {
				for(int c =0;c<COL;c++) {
					if(visit[r][c]==false && map[r][c]==1) {
						// queue clear
						q.clear();
						cnt++;
						bfs(r,c,cnt);
					}
				}
			}
			
			// 출력
			System.out.println(cnt);
			
			// 마지막에 다음을 위한 입력
			// 너비(COL) 높이(ROW)
			st = new StringTokenizer(br.readLine());
			COL = Integer.parseInt(st.nextToken());
			ROW = Integer.parseInt(st.nextToken());
		}
	}
	
	public static void bfs(int row,int col,int cnt) {
		// queue에 넣고 방문 처리
		q.add(new Pos(row,col,cnt));
		visit[row][col] = true;
		
		while(!q.isEmpty()) {
			
			Pos k = q.poll();
			
			for(int d=0;d<8;d++) {
				int nr = k.r + dr[d];
				int nc = k.c + dc[d];
				
				if(nr>=0 && nr<ROW && nc>=0 && nc<COL) {
					if(visit[nr][nc]==false && map[nr][nc]==1) {
						map[nr][nc] =cnt;
						visit[nr][nc] = true;
						q.add(new Pos(nr,nc,cnt));
					}
				}
			}
		}
		
	}
	
	static class Pos{
		int r;
		int c;
		int cnt;
		
		public Pos(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}