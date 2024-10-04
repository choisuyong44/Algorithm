import java.io.*;
import java.util.*;

public class Solution {

	static int tc;
	static boolean[][] map;
	static boolean[][] visited;
	static int src_x,src_y,dest_x,dest_y,nr,nc;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int T= 0;T<10;T++) {
			tc = Integer.parseInt(br.readLine());
			map = new boolean[16][16];
			visited = new boolean[16][16];
			for(int i =0;i<16;i++) {
				String s = br.readLine();
				for(int j =0;j<16;j++) {
					if(s.charAt(j)=='1')map[i][j] = false;
					else map[i][j] = true;
					if(s.charAt(j)=='2') {
						src_y = i; src_x =j;
					}
					if(s.charAt(j)=='3') {
						dest_y = i; dest_x =j;
					}
				}
			}
			if(bfs(src_y,src_x))sb.append("#").append(tc).append(" ").append("1\n");
			else sb.append("#").append(tc).append(" ").append("0\n");
		}
		System.out.println(sb.toString());
	}
	public static boolean bfs(int r, int c) {
		q.clear(); visited[r][c] = true;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			if(k[0]==dest_y && k[1]==dest_x) {
				return true;
			}
			for(int d = 0;d<4;d++) {
				nr = k[0]+dr[d];
				nc = k[1]+dc[d];
				if(nr>=0 && nr<16 && nc>=0 && nc<16) {
					if(map[nr][nc] && !visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
		return false;
	}
}