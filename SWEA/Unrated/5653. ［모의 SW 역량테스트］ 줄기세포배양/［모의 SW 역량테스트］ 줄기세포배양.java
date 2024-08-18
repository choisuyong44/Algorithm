import java.io.*;
import java.util.*;

import javax.swing.CellEditor;

public class Solution {

	static final int DEAD = 0;
	static final int ACTIVE = 1;
	static final int DEACTIVE = 2;

	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static int N, M, K;

	static boolean[][] visit;

	static List<Cell> list;
	static PriorityQueue<Cell> pq = new PriorityQueue<Cell>(new Comparator<Cell>() {
		@Override
		public int compare(Cell o1, Cell o2) {
			return o2.ready - o1.ready;
		};
	});

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			pq.clear();
			
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			visit = new boolean[N + K + 1][M + K + 1];
			list = new ArrayList<Cell>();
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int k = Integer.parseInt(st.nextToken());
					if (k > 0) {
						visit[i + K / 2][j + K / 2] = true;
						list.add(new Cell(i + K / 2, j + K / 2, k));
					}
				}
			}

			grow();

			int cnt = 0;
			for (Cell c : list) {
				if (c.status == ACTIVE || c.status == DEACTIVE) {
					cnt++;
				}
			}
			sb.append("#").append(T).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void grow() {

		while (K-- >= 0) {

			while (!pq.isEmpty()) {
				Cell tmp = pq.poll();

				for (int d = 0; d < 4; d++) {
					int nr = tmp.r + dr[d];
					int nc = tmp.c + dc[d];
					
					if(visit[nr][nc]==false) {
						visit[nr][nc] = true;
						list.add(new Cell(nr,nc,tmp.ready));
					}
				}
			}
			
			for(Cell c :list) {
				c.next();
			}
		}
	}

	static class Cell {
		int r, c, status, life, ready;

		public Cell(int r, int c, int ready) {
			this.r = r;
			this.c = c;
			this.status = DEACTIVE;
			this.ready = ready;
			this.life = ready * 2;
		}

		void next() {
			if (status == DEAD)
				return;

			else if (life == ready && status == DEACTIVE) {
				life--;
				status = ACTIVE;
				pq.add(this);
				return;
			}

			else if (life == 0 && status == ACTIVE) {
				status = DEAD;
			}

			life--;
		}
	}
}