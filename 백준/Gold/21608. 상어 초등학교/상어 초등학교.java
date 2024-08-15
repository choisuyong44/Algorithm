import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int[][] room, like;

	static int N;

	static PriorityQueue<Seat> candiSeat = new PriorityQueue<Seat>(new Comparator<Seat>() {
		@Override
		public int compare(Seat o1, Seat o2) {
			if (o1.like != o2.like)
				return o2.like - o1.like;
			if (o1.empty != o2.empty)
				return o2.empty - o1.empty;
			if (o1.r != o2.r)
				return o1.r - o2.r;
			return o1.c - o2.c;
		};
	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		like = new int[N * N][5];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				like[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N * N; i++) {

			Seat best = findSeat(i);
			room[best.r][best.c] = like[i][0];
		}

		int ans = 0;
		int now;
		int num;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				now = room[i][j];

				for (int s = 0; s < N * N; s++) {
					if (now == like[s][0]) {
						now = s;
						break;
					}
				}

				num = countLike(i, j, now);

				switch (num) {
				case 1:
					ans += 1;
					break;
				case 2:
					ans += 10;
					break;
				case 3:
					ans += 100;
					break;
				case 4:
					ans += 1000;
					break;
				}
			}
		}

		System.out.println(ans);
	}

	public static Seat findSeat(int idx) {
		candiSeat.clear();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (room[i][j] == 0) {
					candiSeat.add(new Seat(countLike(i, j, idx), countEmpty(i, j), i, j));
				}
			}
		}

		return candiSeat.poll();
	}

	public static int countLike(int r, int c, int idx) {
		int cnt = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {

				for (int i : like[idx]) {
					if (i == room[nr][nc])
						cnt++;
				}
			}
		}

		return cnt;
	}

	public static int countEmpty(int r, int c) {
		int cnt = 0;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if (room[nr][nc] == 0) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	public static void printRoom() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				System.out.print(room[r][c]);
			}
			System.out.println();
		}
	}
}

class Seat {
	int like;
	int empty;
	int r;
	int c;

	public Seat(int like, int empty, int r, int c) {
		this.like = like;
		this.empty = empty;
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.like + " " + this.empty + " " + r + " " + c;
	}
}