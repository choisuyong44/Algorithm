import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	// o 양
	// v 늑대
	// . 빈 칸
	// # 울타리
	static int R,C;
	static char[][] map;
	static int sheep,wolf;
	static boolean[][] visited;
	static Queue<int[]> q= new LinkedList<>();
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i =0;i<R;i++) {
			String s = br.readLine();
			for(int j =0;j<C;j++) {
				map[i][j] =s.charAt(j);
				if(map[i][j]=='o')sheep++;
				else if(map[i][j]=='v')wolf++;
			}
		}
		
		
		for(int i =0;i<R;i++) {
			for(int j =0 ;j<C;j++) {
				if(!visited[i][j] && map[i][j]!='#') {
					bfs(i,j);
				}
			}
		}
		System.out.println(sheep + " "+wolf);
	}
	
	public static void bfs(int r,int c) {
		int v =0; int o =0;
		if(map[r][c]=='v')v++;
		if(map[r][c]=='o')o++;
		visited[r][c] = true;
		q.add(new int[] {r,c});
		while(!q.isEmpty()) {
			int[] k = q.poll();
			for(int d =0;d<4;d++) {
				int nr = k[0]+dr[d];
				int nc = k[1]+dc[d];
				if(nr>=0 && nr<R && nc>=0 && nc<C) {
					if(!visited[nr][nc] && map[nr][nc]!='#') {
						visited[nr][nc] = true;
						q.add(new int[] {nr,nc});
						if(map[nr][nc]=='v')v++;
						if(map[nr][nc]=='o')o++;
					}
				}
			}
		}
		if(v>=o) sheep-=o;
		else wolf-=v;
	}
}