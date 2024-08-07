import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1,-1,0,1,1,1,0,-1};
	static int[] dc = {0,1,1,1,0,-1,-1,-1};
	
	// n 사이즈가 작으니까 메모리 다쓰자
	static char[][] map;
	static char[][] Boomb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		Boomb = new char[N][N];
		
		
		for (int r =0;r<N;r++) {
			String s = br.readLine();
			for(int c = 0;c<N;c++) {
				Boomb[r][c] = s.charAt(c);
			}
		}
		
		for (int r =0;r<N;r++) {
			String s = br.readLine();
			for(int c = 0;c<N;c++) {
				map[r][c] = s.charAt(c);
			}
		}
		
		for(int r = 0;r<N;r++) {
			for(int c =0 ;c<N;c++) {
				int cnt  =0;
				int nr; int nc;
				// x인 경우
				if(map[r][c] =='x') {
					
					// 방향 8가지
					for(int d =0 ;d<dr.length;d++) {
						nr = r + dr[d];
						nc = c + dc[d];
						
						if(nr >=0 && nr< N && nc>=0 &&nc<N) {
							if(Boomb[nr][nc] =='*') {
								cnt++;
							}
						}
					}
					
					map[r][c] = (char)('0'+cnt);
					
					if(Boomb[r][c]=='*') {
						for(int i =0;i<N;i++) {
							for(int j =0;j<N;j++) {
								if(Boomb[i][j]=='*') {
									map[i][j]='*';
								}
							}
						}
					}
				}
			}
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		for(int r = 0;r<N;r++) {
			for(int c = 0;c<N;c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}
	
		System.out.println(sb);
	}
}