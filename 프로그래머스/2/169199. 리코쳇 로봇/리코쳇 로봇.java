import java.util.*;

class Solution {
    
    static int[] dr = {-1, 0, 1, 0};  // 상, 우, 하, 좌 이동
    static int[] dc = {0, 1, 0, -1};
    static char[][] map;
    static int N, M;
    static int[] R, G;
    static int answer;
    static boolean[][] visited;
    
    public int solution(String[] board) {
        answer = -1;
        
        N = board.length;
        M = board[0].length();
        
        map = new char[N][M];
        R = new int[2];
        G = new int[2];
        
        // 맵 정보 초기화 및 시작점 'R'과 목표점 'G' 위치 저장
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                map[r][c] = board[r].charAt(c);
                if(map[r][c] == 'R') {
                    R[0] = r; 
                    R[1] = c;
                    map[r][c] = '.';  // 'R' 위치를 탐색 가능 상태로 변경
                }
                if(map[r][c] == 'G') {
                    G[0] = r; 
                    G[1] = c;
                }
            }
        }
        
        bfs();
        
        return answer;
    }
    
    static void bfs() {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {R[0], R[1], 0});  // 시작점 (R)에서 시작, 초기 이동 횟수는 0
        visited[R[0]][R[1]] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = cur[2];
            
            // 4방향으로 이동
            for(int i = 0; i < 4; i++) {
                int nr = r, nc = c;
                
                // 벽이나 맵 끝에 닿을 때까지 이동
                while (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != 'D') {
                    nr += dr[i];
                    nc += dc[i];
                }
                
                // 직전 위치로 되돌아감
                nr -= dr[i];
                nc -= dc[i];
                
                // 목표점에 도달한 경우
                if(map[nr][nc] == 'G') {
                    answer = cnt+1;
                    return;
                }
                
                // 아직 방문하지 않은 곳이면 큐에 추가
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc, cnt + 1});
                }
            }
        }
    }
}
