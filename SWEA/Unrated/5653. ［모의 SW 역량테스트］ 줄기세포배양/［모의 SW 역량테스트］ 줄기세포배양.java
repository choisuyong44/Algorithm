import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    final static int DEAD = -1;
    final static int DEACTIVE = 0;
    final static int ACTIVE = 1;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Cell implements Comparable<Cell> {
        int status = DEACTIVE;
        int life;
        int now_life;
        int y, x;

        public Cell(int life, int y, int x) {
            this.life = life;
            this.now_life = life;
            this.y = y;
            this.x = x;
        }

        public void progress() {
            if (status == DEAD) return;

            if (status == DEACTIVE) {
                now_life--;
                if (now_life == 0) {
                    status = ACTIVE;
                    now_life = life;
                    active.add(this);
                    deactive.remove(this);
                }
            } 
            
            else if (status == ACTIVE) {
                // 감염(세포 번식)
                for (int d = 0; d < 4; d++) {
                    int nr = y + dr[d];
                    int nc = x + dc[d];
                    if(!visited[nr][nc]) pq.add(new Cell(life, nr, nc));
                }
            	now_life--;
                if (now_life == 0) {
                    status = DEAD;
                    active.remove(this);
                }
            }
        }

        @Override
        public String toString() {
            return "Cell [status=" + status + ", life=" + life + ", now_life=" + now_life + ", y=" + y + ", x=" + x
                    + "]" + "\n";
        }

        @Override
        public int compareTo(Cell o) {
            return o.life - this.life;
        }
    }

    static int N, M, K, ans;
    static boolean[][] visited;
    static List<Cell> deactive = new ArrayList<>();
    static List<Cell> active = new ArrayList<>();
    static PriorityQueue<Cell> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            deactive.clear();
            active.clear();

            input();
            for (int i = 0; i < K; i++) {
            	
                // 세포의 생명 주기 진행
                for (int c = active.size() - 1; c >= 0; c--) {
                    active.get(c).progress();
                }

                for (int c = deactive.size() - 1; c >= 0; c--) {
                    deactive.get(c).progress();
                }

                // pq에서 꺼내서 deactive에 넣기
                while (!pq.isEmpty()) {
                    Cell newCell = pq.poll();
                    if (!visited[newCell.y][newCell.x]) {
                        deactive.add(newCell);
                        visited[newCell.y][newCell.x] = true;
                    }
                }
            }
            
            ans = active.size() + deactive.size();

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2 * K + N][2 * K + M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k != 0) {
                    deactive.add(new Cell(k, i + K, j + K));
                    visited[i + K][j + K] = true;
                }
            }
        }
    }
}