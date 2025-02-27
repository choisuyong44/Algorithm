import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};
    static int N,SHARK_R,SHARK_C,Q_SZ, SHARK_SZ, BREAD_COUNT;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> q;
    static PriorityQueue<int[]> selected = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if(o1[0] == o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        }
    });

    public static void main(String[] args) throws IOException {
        int ans =0; int t =0;
        input();
        while((t = nextTarget()) != -1 ) {
            ans +=t;
            choose();
        }
        System.out.println(ans);
    }

    static int nextTarget() {
        q = new LinkedList<>();
        visited = new boolean[N][N];
        selected.clear();

        q.add(new int[]{SHARK_R,SHARK_C});
        visited[SHARK_R][SHARK_C] = true;

        int time = -1;
        boolean flag = false;
        while(!q.isEmpty()) {

            Q_SZ = q.size();
            time++;

            for(int i = 0; i < Q_SZ; i++) {
                int[] cur = q.poll();

                // target 고르기
                if(map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < SHARK_SZ){
                    selected.add(cur);
                    flag = true;
                }

                for(int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if(nr < 0 || nc < 0 || nr >= N || nc >= N
                            || visited[nr][nc]) continue;
                    if(map[nr][nc] > SHARK_SZ) continue;

                    q.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                }
            }

            if(flag) return time;
        }

        return -1;
    }

    static void choose(){
        int[] cur = selected.poll();
        map[cur[0]][cur[1]] = 0;
        map[SHARK_R][SHARK_C] = 0;

        SHARK_R = cur[0];
        SHARK_C = cur[1];

        BREAD_COUNT++;

        if(BREAD_COUNT == SHARK_SZ){
            BREAD_COUNT = 0;
            SHARK_SZ++;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        SHARK_SZ = 2;
        BREAD_COUNT = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    SHARK_R = i;
                    SHARK_C = j;
                }
            }
        }
    }
}