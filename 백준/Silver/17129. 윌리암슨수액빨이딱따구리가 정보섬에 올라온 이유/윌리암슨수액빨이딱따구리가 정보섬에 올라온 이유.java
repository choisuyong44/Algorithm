import java.io.*;
import java.util.*;

class Point {
	int x;
	int y;
	
	public Point(int row, int col) {
		this.x = col;
		this.y = row;
	}
}

public class Main {

	static int N;
	static int M;
	
	static char[][] map;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int row =0 ;int col =0 ;
		map = new char[N][M];
		
		String s;char c;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<M;j++) {
				c = s.charAt(j);
				
				if(c =='2') {
					map[i][j] ='0';
					row= i; col=j;
				}
				
				else if(c =='0') {
					map[i][j] ='0';
				}
				
				else if(c == '1') {
					map[i][j] = '.';
				}
				
				else {
					map[i][j] = '*';
				}
			}
		}
		
		int ans = 0;
		ans = bfs(row,col);
		
		if(ans == 0) {
			System.out.println("NIE");
		}
		
		else {
			System.out.println("TAK");
			System.out.println(ans);
		}
	}
	
	public static int bfs(int row, int col) {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.offer(new Point(row,col));
		Point p; int r; int c;
		while(!queue.isEmpty()) {
			
			p = queue.poll();
			r = p.y; c= p.x;
			// printMap();
			
			for(int d =0;d<4;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr< N && nc >=0 && nc <M) {
					
					if(map[nr][nc] == '0') {
						map[nr][nc] = (char)(map[r][c]+1);
						queue.offer(new Point(nr,nc));
					}
					
					else if(map[nr][nc]== '*') {
						return (map[r][c]+1 -'0');
					}
				}
			}
		}
		return 0;
	}
	
	public static void printMap() {
		System.out.println("==========================================");
		for(int r = 0;r<N;r++) {
			for(int c =0 ;c<M;c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println("==========================================");
	}
}