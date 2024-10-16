import java.io.*;
import java.util.*;


public class Main {
	
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	static int ans;
	
	public static void main(String[] args) throws IOException{
		input();
		ans =0;
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				if(!visited[i][j]) {
					bfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int r, int c) {
		visited[r][c] = true;
		
		// 가로만 탐색
		if(map[r][c]=='-') {
			while(true) {
				c++;
				if(c<M && map[r][c]=='-') {
					visited[r][c] = true;
				}
				else return;
			}
		}
		
		// 세로만 탐색
		else {
			while(true) {
				r++;
				if(r<N && map[r][c]=='|') {
					visited[r][c] = true;
				}
				// N보다 큰 경우
				// |가 아닌 경우
				else return;
			}
		}
	}
	
	public static void input() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M]; visited = new boolean[N][M];
		for(int i =0;i<N;i++) {
			String s = br.readLine();
			for(int j = 0;j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
	}
}