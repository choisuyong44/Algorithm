import java.io.*;
import java.util.*;

public class Main {

	// 방향
	static final int[] dr = {-1,0,1,0};
	static final int[] dc = {0,1,0,-1};
	
	// 맵 정보
	static int N,M;
	static int[][] map;
	
	// 정답
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. map 크기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 2. 로봇 좌표, 방향
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// 3. map 정보
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 4. clean
		clean(r,c,d);
		
		// 5. 출력
		System.out.println(cnt);
	}
	
	// 벽 : 1, 청소x : 0, 청소o : 2
	public static void clean(int r, int c, int d) {
		// 자기 자리 청소
		map[r][c] = 2;
		cnt++;
		
		// 반복
		out : while(true) {
		
		
			// 4방 둘러보기 - 청소할 구역 찾기
			for(int i =0;i<4;i++) {
				d = (4+d-1)%4;
				
				int nr = r + dr[d]; 
				int nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 &&nc<M) {
					// 벽 x이고 청소 x인 구역
					if(map[nr][nc] == 0) {
						map[nr][nc] = 2;
						r = nr; c= nc;
						cnt++;
						continue out;
					}
				}
			}
			
			// 4방탐색 결과 청소할 구역 x 뒤로 한칸 이동
			// 보는 방향은 고정
			int nr = r + dr[(d+2)%4];
			int nc = c + dc[(d+2)%4];
			
			// 뒤에 공간이 있음
			if(nr>=0 && nr<N && nc>=0 && nc<M) {
				if(map[nr][nc] == 1) {
					return;
				}
				
				else if(map[nr][nc] ==0){
					map[nr][nc] = 2;
					r = nr; c= nc;
					cnt++;
				}
				
				else if(map[nr][nc] ==2){
					r = nr; c= nc;
				}
			}
			
			// 뒤에 공간이 없음
			else return;
		}
	}
	
	public static void printMap() {
		System.out.println("=================================");
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}