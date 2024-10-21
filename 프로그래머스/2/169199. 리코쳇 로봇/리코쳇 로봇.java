import java.util.*;

class Solution {
    
    public int solution(String[] board) {
        
        int N = board.length;
        int M = board[0].length();
        // System.out.println(N);
        // System.out.println(M);
        
        int startR = 0, startC = 0;
        int goalR = 0, goalC = 0;
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){
                    startR = i;
                    startC = j;
                } else if(map[i][j] == 'G'){
                    goalR = i;
                    goalC = j;
                }
            }
        }
        
        // System.out.println(startR + " " + startC);
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        boolean isPoss = false;
        for (int d = 0; d < 4; d++){
            int nr = goalR + dr[d];
            int nc = goalC + dc[d];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'D') {
                isPoss = true;
                break;
            }
        }
        
        if(!isPoss){
            return -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        for (int d = 0; d < 4; d++){
            int nr = startR + dr[d];
            int nc = startC + dc[d];
            
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'D') continue;
            
            q.offer(new int[] {nr, nc, d, 0});
        }
        
        // System.out.println(q);
        boolean[][] visit = new boolean[N][M];
        visit[startR][startC] = true;
        int cnt = -1;
        // boolean canTouch = false;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            int curR = cur[0];
            int curC = cur[1];
            int nextR = curR + dr[cur[2]];
            int nextC = curC + dc[cur[2]];

            while(nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && map[nextR][nextC] != 'D'){
                curR = nextR;
                curC = nextC;
                nextR = curR + dr[cur[2]];
                nextC = curC + dc[cur[2]];
            }
            
            if(visit[curR][curC]) continue;
            
            cur[3]++;
            if(map[curR][curC] == 'G') {
                cnt = cur[3];
                // canTouch = true;
                break;
            }
            
            System.out.println(cur[3] + ": " + curR + " " + curC);
            visit[curR][curC] = true;
            for (int d = 0; d < 4; d++){
                int nr = curR + dr[d];
                int nc = curC + dc[d];
                
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'D' || visit[nr][nc]) continue;
                
                q.offer(new int[] {nr, nc, d, cur[3]});
            }
        }
        
        return cnt;
    }
    
//     static void move(int r, int c, int d){
//         int curR = r;
//         int curC = c;
//         int nextR = curR + dr[d];
//         int nextC = curC + dc[d];
        
//         while(map[nextR][nextC] != 'D'){
//             curR = nextR;
//             curC = nextC;
//             nextR = curR + dr[d];
//             nextC = curC + dc[d];
//         }
//     }
}