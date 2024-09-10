import java.io.*;
import java.util.*;

public class Main {
	
	static int min;
	
	static int N,M,K;
	static int[][] map;
	static int[][] op;
	static int[] ordered;
	static int[][] tempMap;
	static boolean[] visit;
	
	// 아래쪽 -> 오른쪽 -> 위쪽 -> 왼쪽
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
 
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		op = new int[K][3];
		ordered = new int[K];
		visit = new boolean[K];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// rotation
		// -1을 해서 index로 생각
		for(int i =0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
		
			op[i] = new int[] {r,c,w};
		}
		
		min = Integer.MAX_VALUE;
		perm(0);
		System.out.println(min);
	}
	
	public static void perm(int depth) {
		if(depth == K) {
			
			// 새로운 배열을 생성해야 함
			// 깊은 복사 때문에 
			tempMap = new int[N][M];
			for(int i =0;i<N;i++) {
				for(int j =0;j<M;j++) {
					tempMap[i][j] = map[i][j];
				}
			}
			
			// 회전
			for(int i =0;i<K;i++) {
				for(int j =1;j<=op[ordered[i]][2];j++) {
					rotation(op[ordered[i]][0],op[ordered[i]][1], j);
				}
			}
			
			// 결과 출력
			for(int i =0;i<N;i++) {
				int sum =0;
				for(int j =0;j<M;j++) {
					sum += tempMap[i][j];
				}
				min = Math.min(min, sum);
			}
		}
		
		for(int i=0;i<K;i++) {
			if(!visit[i]) {
				visit[i] = true;
				ordered[depth] = i;
				perm(depth+1);
				visit[i] = false;
			}
		}
	}
	
	public static void rotation(int r, int c, int w) {
		// 좌상단
		int old_r = r-w;
		int old_c = c-w;
		int d = 0; 
		
		int tmp = tempMap[old_r][old_c];
		
		// 원점으로 돌아온 경우
		while(true) {

			// 다음 이동 좌표
			int new_r = old_r + dr[d];
			int new_c = old_c + dc[d];

			// 범위 안에 있으면
			if(new_r >= r-w && new_r <= r+w && new_c >= c-w && new_c <=c+w) {
				
				if(new_r == r-w && new_c ==c-w) {
					tempMap[old_r][old_c] = tmp;
					return;
				}
				
				tempMap[old_r][old_c] = tempMap[new_r][new_c];
				old_r = new_r;
				old_c = new_c;
			}
			
			else {
				d = (d+1)%4;
			}
		}
	}
	
	public static void printMap() {
		System.out.println("==============================");
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				System.out.print(tempMap[i][j] +" ");
			}
			System.out.println();
		}
	}
}