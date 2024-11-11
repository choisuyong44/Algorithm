import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static int N, max;
    static int[][] map;
    static int[][] origin;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(max);
    }
    
    // DFS를 통해 5번의 움직임을 탐색
    public static void dfs(int depth) {
        if (depth == 5) {
            simulation();
            findMax();
            return;
        }
        for (int i = 0; i < 4; i++) {
            list.add(i);
            dfs(depth + 1);
            list.remove(list.size() - 1);
        }
    }
    
    // 시뮬레이션: 원본 맵을 복사한 후 움직임 수행
    public static void simulation() {
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(origin[i], 0, map[i], 0, N);
        }
        
        for (int direction : list) {
            move(direction);
        }
    }
    
    /*
     * move 메서드: 특정 방향으로 모든 블록을 이동하고 합침
     * 0 = 상, 1 = 하, 2 = 좌, 3 = 우
     */
    public static void move(int direction) {
        if (direction == 0) { // 위로 이동
            for (int c = 0; c < N; c++) {
                int[] temp = new int[N];
                int index = 0;
                for (int r = 0; r < N; r++) {
                    if (map[r][c] != 0) {
                        if (temp[index] == map[r][c]) { // 블록 합치기
                            temp[index++] *= 2;
                        } else if (temp[index] == 0) {
                            temp[index] = map[r][c];
                        } else {
                            temp[++index] = map[r][c];
                        }
                    }
                }
                for (int r = 0; r < N; r++) {
                    map[r][c] = temp[r];
                }
            }
        } else if (direction == 1) { // 아래로 이동
            for (int c = 0; c < N; c++) {
                int[] temp = new int[N];
                int index = 0;
                for (int r = N - 1; r >= 0; r--) {
                    if (map[r][c] != 0) {
                        if (temp[index] == map[r][c]) {
                            temp[index++] *= 2;
                        } else if (temp[index] == 0) {
                            temp[index] = map[r][c];
                        } else {
                            temp[++index] = map[r][c];
                        }
                    }
                }
                for (int r = N - 1, i = 0; r >= 0; r--, i++) {
                    map[r][c] = temp[i];
                }
            }
        } else if (direction == 2) { // 왼쪽으로 이동
            for (int r = 0; r < N; r++) {
                int[] temp = new int[N];
                int index = 0;
                for (int c = 0; c < N; c++) {
                    if (map[r][c] != 0) {
                        if (temp[index] == map[r][c]) {
                            temp[index++] *= 2;
                        } else if (temp[index] == 0) {
                            temp[index] = map[r][c];
                        } else {
                            temp[++index] = map[r][c];
                        }
                    }
                }
                for (int c = 0; c < N; c++) {
                    map[r][c] = temp[c];
                }
            }
        } else if (direction == 3) { // 오른쪽으로 이동
            for (int r = 0; r < N; r++) {
                int[] temp = new int[N];
                int index = 0;
                for (int c = N - 1; c >= 0; c--) {
                    if (map[r][c] != 0) {
                        if (temp[index] == map[r][c]) {
                            temp[index++] *= 2;
                        } else if (temp[index] == 0) {
                            temp[index] = map[r][c];
                        } else {
                            temp[++index] = map[r][c];
                        }
                    }
                }
                for (int c = N - 1, i = 0; c >= 0; c--, i++) {
                    map[r][c] = temp[i];
                }
            }
        }
    }
    
    // 보드의 최대값 찾기
    public static void findMax() {
        for (int[] row : map) {
            for (int num : row) {
                max = Math.max(max, num);
            }
        }
    }
    
    // 입력 처리
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        origin = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}