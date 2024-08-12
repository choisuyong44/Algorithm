import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		map = new int[1001][1001];

		int rstart;
		int cstart;
		int rgap;
		int cgap;

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			rstart = Integer.parseInt(st.nextToken());
			cstart = Integer.parseInt(st.nextToken());
			rgap = Integer.parseInt(st.nextToken());
			cgap = Integer.parseInt(st.nextToken());

			for (int r = rstart; r < rstart + rgap; r++) {
				for (int c = cstart; c < cstart + cgap; c++) {
					map[r][c] = i;
				}
			}
		}
		
		// printMap();
		
		for (int i = 1; i < N + 1; i++) {
			int cnt =0;
			for (int r = 0; r < 1001; r++) {
				for (int c = 0; c < 1001; c++) {
					if (map[r][c] == i)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	public static void printMap() {
		for(int i =0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}