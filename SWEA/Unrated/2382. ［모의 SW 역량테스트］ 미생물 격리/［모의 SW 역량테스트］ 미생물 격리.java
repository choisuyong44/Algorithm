import java.util.*;
import java.io.*;

public class Solution {

	// 상 = 1;
	// 하 = 2;
	// 좌 = 3;
	// 우 = 4
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	static class Ecoli {
		int r;
		int c;
		int cnt;
		int direction;

		public Ecoli(int r, int c, int cnt, int direction) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.direction = direction;
		}

		public void move() {
			this.r = this.r + dr[this.direction];
			this.c = this.c + dc[this.direction];
		}

		@Override
		public String toString() {
			return "Ecoli [r=" + r + ", c=" + c + ", cnt=" + cnt + ", direction=" + direction + "]";
		}
	}

	// N : 한변의 길이 (NxN)
	// M : 격리 시간
	// K : 군집의 수
	static int N, M, K;
	static List<Ecoli> tmp;
	static List<Ecoli>[][] candi;
	static List<Ecoli> ecolies;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {

			// 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ecolies = new ArrayList<Ecoli>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());
				ecolies.add(new Ecoli(r, c, cnt, direction));
			}

			for (int i = 0; i < M; i++) {
				// System.out.println(i+ " : " + ecolies.size()+ " "+ecolies);
				simulation();
			}

			int ans = countEcoli();

			sb.append("#").append(T).append(" ").append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void simulation() {
		candi = new ArrayList[N][N];
		tmp = new ArrayList<Ecoli>();

		for (Ecoli e : ecolies) {
			// 움직이고 난 후 
			e.move();
			
			// 해당 위체의 후보로 저장
			if (candi[e.r][e.c] == null) {
				candi[e.r][e.c] = new ArrayList<Ecoli>();
				candi[e.r][e.c].add(e);
				continue;
			} 
			
			// 이미 해당 위치의 다른 후보가 있다면 추가
			else {
				candi[e.r][e.c].add(e);
			}
		}

		// 갱신
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 비어있는 경우 -> 후보가 아예 없음
				if (candi[i][j] == null)
					continue;

				// 합치는 경우 - 후보가 여러개
				if (candi[i][j].size() > 1) {
					int max = candi[i][j].get(0).cnt;
					int max_d = candi[i][j].get(0).direction;
					int sum = 0;
					for (Ecoli e : candi[i][j]) {
						if (max < e.cnt) {
							max = e.cnt;
							max_d = e.direction;
						}
						sum += e.cnt;
					}
					tmp.add(new Ecoli(i, j, sum, max_d));
				}

				// 방향이 바뀌는 경우
				else if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
					candi[i][j].get(0).cnt /= 2;
					switch(candi[i][j].get(0).direction) {
					case 1:
						candi[i][j].get(0).direction = 2;
						break;
					case 2:
						candi[i][j].get(0).direction = 1;
						break;
					case 3:
						candi[i][j].get(0).direction = 4;
						break;
					case 4:
						candi[i][j].get(0).direction = 3;
						break;
					}
					
					tmp.add(candi[i][j].get(0));
				}

				else if(candi[i][j].size() == 1) {
					tmp.add(candi[i][j].get(0));
				}
			}
		}

		// 다시 넣기
		ecolies = tmp;
	}

	public static int countEcoli() {
		int ans = 0;

		for (int i = 0; i < ecolies.size(); i++) {
			ans += ecolies.get(i).cnt;
		}
		return ans;
	}
}