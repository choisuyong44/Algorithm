import java.util.*;
import java.io.*;

public class Main {

	/*
	 * 바깥 2
	 * 치즈 1
	 * 내부 0
	 */
	static int N,M,nr,nc;
	static List<int[]> list;
	static Queue<int[]> q = new LinkedList<>();
	static boolean[][] visited;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cheeseCnt, time;
	
	public static void main(String[] args) throws IOException{
		input();
		time =0; int cnt=0;
		map[0][0] = 2;
		while(true) {
			if(cheeseCnt==0) break;
			time++;
			
			// 영역 표시하기
			visited = new boolean[N][M];
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(!visited[i][j] && map[i][j]==2) {
						exterUpdate(i,j);
					}
				}
			}
			
			// 녹을 치즈 고르기
			list = new ArrayList<>();
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					if(map[i][j]==1) {
						cnt =0;
						for(int d =0;d<4;d++) {
							nr = i+dr[d];
							nc = j+dc[d];
							if(map[nr][nc]==2) cnt++;
						}
						if(cnt>=2) list.add(new int[] {i,j});
					}
				}
			}
			
			// 치즈 업데이트
			for(int[] k: list) {
				map[k[0]][k[1]] = 2;
				cheeseCnt--;
			}
		}
		
		System.out.println(time);
	}
	
	public static void exterUpdate(int r, int c) {
		q.clear(); q.add(new int[] {r,c}); 
		map[r][c] =2; visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d= 0;d<4;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				
				if(nr >=0 && nr<N && nc>=0 && nc <M && !visited[nr][nc]) {
					if(map[nr][nc] == 0 || map[nr][nc]==2) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
						map[nr][nc] = 2;
					}
				}
			}
		}
	}

	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cheeseCnt =0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cheeseCnt++;
			}
		}
	}
}