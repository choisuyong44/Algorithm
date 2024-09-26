import java.io.*;
import java.util.*;

public class Main {

	static Queue<Move> q = new LinkedList<Move>();

	static class Move {
		int x;
		int y;
		int z;
		int cost;

		public Move(int x, int y, int z, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.cost = cost;
		}
	}

	static int min = 9999;

	static boolean[][][] ans;
	static boolean[][][] map;

	static boolean[][][] visitedCube;
	static boolean[] visitedFloor;
	static int[] orderDirection = new int[5];

	static final int[] dx = { -1, 1, 0, 0, 0, 0 };
	static final int[] dy = { 0, 0, -1, 1, 0, 0 };
	static final int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();
		simulation();

		if (min == 9999)min = -1;
		System.out.println(min);
	}

	public static void simulation() {
		visitedFloor = new boolean[5];
		perm(0);
	}

	// 층에 대한 순열
	public static void perm(int depth) {
		if (depth == 5) {
			decisionDirection(0);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!visitedFloor[i]) {
				visitedFloor[i] = true;
				ans[depth] = map[i];
				perm(depth + 1);
				visitedFloor[i] = false;
			}
		}
	}

	// 각각의 층에 대한 회전 정보
	public static void decisionDirection(int depth) {
		if(depth == 5) {
			rotate(1);
			bfs();
			rotate(-1);
			return;
		}
		
		for(int i =0;i<4;i++) {
			orderDirection[depth] = i;
			decisionDirection(depth+1);
		}
	}

	public static void bfs() {
		if(!ans[0][0][0] || !ans[4][4][4]) return;
		
		q.clear();
		visitedCube = new boolean[5][5][5];
		
		q.add(new Move(0, 0, 0, 0));
		visitedCube[0][0][0] = true;
		
		int nx,ny,nz;
		while(!q.isEmpty()) {
			
			Move k = q.poll();
			
			if(min==12) return;
			if(k.x==4 &&k.y==4&&k.z==4) {
				min = Math.min(k.cost, min);
				return;
			}
			
			for(int d =0;d<6;d++) {
				nx = k.x+dx[d];
				ny = k.y+dy[d];
				nz = k.z+dz[d];
				
				if (isValid(nx,ny,nz)) {
					q.add(new Move(nx,ny,nz,k.cost+1));
					visitedCube[nz][ny][nx] = true;
				}
			}
		}
	}
	
	public static boolean isValid(int x, int y, int z) {
		if( x>=0 && x<5 && y>=0 && y<5 && z>=0 && z<5 ) {
			if(!visitedCube[z][y][x] && ans[z][y][x]) {
				return true;
			}
		}
		return false;
	}

	public static void rotate(int direct) {
		// 5층
		for(int i =0;i<5;i++) {
			
			// orderDirection 횟수 만큼 회전
			int rotateCnt = orderDirection[i];
			if(direct == -1) rotateCnt = 4- rotateCnt;
			
			// 층에 대한 정보
			boolean[][] temp = new boolean[5][5];
			for(int j =0;j<rotateCnt;j++) {
				
				// temp에 넣기
				for(int r = 0;r<5;r++) {
					for(int c = 0;c<5;c++) {
						temp[c][4-r] = ans[i][r][c];
					}
				}
				
				// 회전된 배열을 다시 원본 배열에 복사
				for (int r = 0; r < 5; r++) {
					for (int c = 0; c < 5; c++) {
						ans[i][r][c] = temp[r][c];
					}
				}
			}
		}
	}


	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ans = new boolean[5][5][5];
		map = new boolean[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 5; k++) {
					if (Integer.parseInt(st.nextToken()) == 1)
						map[i][j][k] = true;
				}
			}
		}
	}
}