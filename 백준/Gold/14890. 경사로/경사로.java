import java.io.*;
import java.util.*;

public class Main {

	static int N,L;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
	
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt =0;
		for(int r =0;r<N;r++) {
			if(isPossible(r, true)) cnt++;	
		}
		
		for(int c = 0;c<N;c++) {
			if(isPossible(c, false)) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean isPossible(int idx,boolean isRow) {
		// Row
		if(isRow) {
			// for문을 통해 idx 확인 하나씩 방문
			int before = map[idx][0];
			int beforeCnt = 1; int i =0;
			i++; 
			while(i<N) {			
				
				// 계단이 2개 차이가 나는 경우
				if(Math.abs(before-map[idx][i]) >=2 ) {
					return false;
				}
					
				// 이전 계단 +1 == 이후 계단
				else if(before+1 == map[idx][i]) {
					if(beforeCnt >= L) {
						before = map[idx][i];
						beforeCnt = 1;
						i++;
					}
					
					else {
						return false;
					}
				}
					
				// 이전 계단-1 == 이후 계단
				else if(before-1 == map[idx][i]) {
					
					// i+L 이 N보다 같거나 큰 상황
					if(i+L>N) return false;
					
					for(int j = 0;j<L;j++) {
						if(map[idx][i+j]!=map[idx][i]) {
							return false;
						}
					}

					before = map[idx][i];
					beforeCnt = 0;
					
					i = i+L;
				}
				
				// 이전 계단 == 이후 계단
				else if(before == map[idx][i]) {
					beforeCnt++;
					i++;
				}
			}
			
			return true;
		}

		// Column
		else {
			// for문을 통해 idx 확인 하나씩 방문
			int before = map[0][idx];
			int beforeCnt = 1; int i =0;
			i++;
			while(i<N) {			
				
				// 계단이 2개 차이가 나는 경우
				if(Math.abs(before-map[i][idx]) >=2 ) {
					return false;
				}
					
				// 이전 계단 +1 == 이후 계단
				else if(before +1 == map[i][idx]) {
					if(beforeCnt >= L) {
						before = map[i][idx];
						beforeCnt = 1;
						i++;
					}
					
					else {
						return false;
					}
					
				}
					
				// 이전 계단 -1 == 이후 계단
				else if(before -1 == map[i][idx]) {
					
					// i+L 이 N보다 같거나 큰 상황
					if(i+L >N) return false;
					
					for(int j = 0;j<L;j++) {
						if(map[i+j][idx]!=map[i][idx]) {
							return false;
						}
					}

					before = map[i][idx];
					beforeCnt = 0;
					
					i = i+L;
					
				}
				
				// 이전 계단 == 이후 계단
				else if(before == map[i][idx]) {
					beforeCnt++;
					i++;
				}
			}
			
			return true;
		}
	}
}