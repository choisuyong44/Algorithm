import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] map;
	static int[][] tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pooling(N);
	}
	
	public static void pooling(int n) {
		// 탈출 조건
		if(n == 1) {
			System.out.println(tmp[0][0]);
			return;
		}
		
		// n/2 배열 생성
		tmp = new int[n/2][n/2];
		
		// map에서 두 번째 값을 tmp에 넣기
		for(int i =0;i<n/2;i++) {
			for(int j =0;j<n/2;j++) {
				tmp[i][j] = second(2*i,2*j);
			}
		}
		
		// map에 tmp 주소 넣기
		map = tmp;
		
		// 반복
		pooling(n/2);
	}
	
	public static int second(int r, int c) {
		int max = Integer.MIN_VALUE;
		int[] k = new int[4];
		int idx =0;
		for(int i = r;i<r+2;i++) {
			for(int j =c;j<c+2;j++) {
				k[idx++] = map[i][j];
			}
		}
		Arrays.sort(k);
		return k[2];
	}
}