import java.io.*;
import java.util.*;

public class Main {

	static int[] jihun, fire;
	static int R,C;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static Queue<int[]> jihunQueue = new LinkedList<int[]>();
	static Queue<int[]> fireQueue = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException{
		input();
		int time = 0;
		while(true) {
			time++;
			int jihunSize = jihunQueue.size();
			int fireSize = fireQueue.size();
			
			// 실패
			if(jihunSize==0) {
				System.out.println("IMPOSSIBLE");
				return;
			}
			
			// fire move
			for(int i = 0;i<fireSize;i++) {
				fire = fireQueue.poll();
				for(int d = 0;d<4;d++) {
					int nr = fire[0]+dr[d];
					int nc = fire[1]+dc[d];
					
					// 범위 체크
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					
					// 이동 가능 검사
					if(map[nr][nc] == '#' || map[nr][nc] == 'F') continue;
					
					fireQueue.add(new int[] {nr,nc});
					
					map[nr][nc] = 'F';
				}
			}
			
			// jihun move
			for(int i = 0;i<jihunSize;i++) {
				jihun = jihunQueue.poll();
				for(int d = 0;d<4;d++) {
					int nr = jihun[0]+dr[d];
					int nc = jihun[1]+dc[d];
					
					// 탈출 성공
					if(nr < 0 || nr >= R || nc< 0 || nc>=C) {
						System.out.println(time);
						return;
					}
					
					// 이동 가능 검사
					if(visited[nr][nc] || map[nr][nc] != '.') continue;
					
					jihunQueue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	public static void printMap() {
		for(int i =0;i<R;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i =0;i<R;i++) {
			String str = br.readLine();
			for(int j = 0;j<C;j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='J') {
					jihunQueue.add(new int[] {i,j});
					visited[i][j] = true;
				}
				else if(map[i][j]=='F') {
					fireQueue.add(new int[] {i,j});
				}
			}
		}
	}
}