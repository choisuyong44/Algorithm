import java.io.*;
import java.util.*;

public class Main {

	static int R;
	static int C;
	
	static char map[][];
	static boolean visit[][];
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean canProtect = true;
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		String s;
		
		for(int r =0;r<R;r++) {
			s = br.readLine();
			for(int c =0;c<C;c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		for(int r= 0;r<R;r++) {
			for(int c = 0;c<C;c++) {
				if(map[r][c]=='S') {
					protectSheep(r, c);
				}
				if(canProtect == false) {
					System.out.println(0);
					return;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("1\n");
		for(int r =0;r<R;r++) {
			for(int c= 0 ;c<C;c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void protectSheep(int r,int c) {
		
		for(int d=0;d<4;d++) {
			int nr = r+ dr[d];
			int nc = c+ dc[d];
			
			if(nr>=0 && nr < R && nc>=0 && nc<C) {
				if(map[nr][nc]=='W') {
					canProtect = false;
					return;
				}
				
				else if(map[nr][nc]=='S' || map[nr][nc] =='D') {
					continue;
				}
				
				else if(map[nr][nc]=='.'){
					map[nr][nc] = 'D';
				}
			}
		}
	}
}