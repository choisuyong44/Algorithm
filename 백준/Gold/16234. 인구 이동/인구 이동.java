import java.io.*;
import java.util.*;

public class Main {

	// ANS
	static int day = 0;
	
	// 2차원 배열
	static int N,L,R;
	static int[][][] map;
	static boolean[][] visit;
	
	final static int GROUP = 0;
	final static int SCORE = 1;
	
	// 2차원 배열 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	// 그룹에 대한 점수 기록
	static int[] groupAvgScore;

	// 같은 그룹인지 판단
	static Queue<Pos> q = new LinkedList<Pos>();
	static int groupNumber, groupSum, groupCnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 입력
		map = new int[N][N][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ;j<N;j++) {
				map[i][j][SCORE] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// N*N이 그룹사이즈와 같으면 국경 여는날 x
		groupNumber = 0;
		while (true) {

			// 초기화 
			groupAvgScore = new int[N*N+1];
			visit = new boolean[N][N];
			
			// 탐색
			groupNumber = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 방문 x
					if (visit[i][j]==false) {
						q.clear();
						groupSum = map[i][j][SCORE];
						groupCnt = 1;
						groupNumber++;
						
						map[i][j][GROUP] = groupNumber;
						bfs(i, j,groupNumber);
						
						// groupAvg값 입력 - 그룹 지정
						groupAvgScore[groupNumber] = groupSum/groupCnt;
				}
				}
			}
			
			if(N*N == groupNumber) {
				break;
			}
			
			// 업데이트
			update();
			// printMap();
		}
		
		System.out.println(day);

	}

	public static void bfs(int r, int c,int n) {
		q.add(new Pos(r, c, n));
		visit[r][c] = true;
		
		while(!q.isEmpty()) {
			
			Pos p = q.poll();
			
			for(int d =0;d<4;d++) {
				int nr = p.r+dr[d];
				int nc = p.c+dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N) {
					if(visit[nr][nc]== false && canOpen(p,nr,nc)) {
						q.add(new Pos(nr,nc,n));
						visit[nr][nc] = true;
						map[nr][nc][GROUP] = n;
						groupCnt++; 
						groupSum += map[nr][nc][SCORE];
					}
				}
			}
		}
	}

	public static void update() {
		day++;
		for(int i =0;i<N;i++) {
			for(int j =0;j<N;j++) {
				// group의 점수는 group Avg
				map[i][j][SCORE] = groupAvgScore[ (map[i][j][GROUP]) ];
			}
		}
	}
	
	public static boolean canOpen(Pos p, int r, int c) {
		int score = Math.abs(map[p.r][p.c][SCORE] - map[r][c][SCORE]);
	
		if(L<=score && score<=R) {
			return true;
		}
		
		return false;
	}

	static class Pos {
		int r;
		int c;
		int group;
		
		public Pos(int r, int c, int group) {
			this.r = r;
			this.c = c;
			this.group = group;
		}
	}

	public static void printMap() {
		System.out.println("++++++++++++++++++++++++++++++++");
		for(int i=0;i<N;i++) {
			for(int j =0;j<N;j++) {
				System.out.print(map[i][j][SCORE]+ " ");
			}
			System.out.println();
		}
	}
}