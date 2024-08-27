import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int min;
	static int[][] map;
	static boolean[] select;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// 입력
		int TC = Integer.parseInt(br.readLine());
		
		for(int T= 1;T<TC+1;T++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			select = new boolean[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j =0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 부분 조합 구하기
			min = Integer.MAX_VALUE;
			
			dfs(0,0);
			
			sb.append("#").append(T).append(" ").append(min).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 부분 조합 함수
	public static void dfs(int idx,int cnt) {
		if(cnt == N/2) {
			// 조합의 차이를 계산하는 함수
			int tmp = diff();
			min = Math.min(min,tmp);
			return;
		}	
		
		
//		if(idx == N){
//			return;
//		}
//			// 고르는 경우
//		select[idx] = true;
//		dfs(idx + 1, cnt + 1);
//
//		// 안고르는 경우
//		select[idx] = false;
//		dfs(idx + 1, cnt);
//	}
		
		for(int i =idx;i<N;i++) {
			// 고르는 경우
			select[i] = true;
			dfs(i+1,cnt+1);
			select[i] = false;
		}
	}
	
	// 조합을 나누었을 때 합을 계산하여 차이를 계산하는 함수 -> 애초에 sum을 구해서 차이를 구하는 방식
	public static int diff() {
		int[] selectIdx = new int[N/2];
		int[] notSelect = new int[N/2];
		
		int cnt =0; int ncnt =0; int tmp =0;
		
		for(int i= 0;i<N;i++) {
			if(select[i] == true) {
				selectIdx[cnt++] = i; 
			}
			else {
				notSelect[ncnt++] = i;
			}
		}
		
		int v1,v2,sum =0;
		for(int i=0;i<N/2-1;i++) {
			int a = selectIdx[i];
			for(int j =i+1;j<N/2;j++) {
				int b = selectIdx[j];
				sum += map[a][b];
				sum += map[b][a];
			}
		}
		
		for(int i=0;i<N/2-1;i++) {
			int a = notSelect[i];
			for(int j =i+1;j<N/2;j++) {
				int b = notSelect[j];
				tmp += map[a][b];
				tmp += map[b][a];
			}
		}
		
		return Math.abs(tmp-sum);
	}
}