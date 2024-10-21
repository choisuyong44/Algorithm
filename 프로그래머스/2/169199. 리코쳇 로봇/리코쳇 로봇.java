import java.io.*;
import java.util.*;

class Solution {
    
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N,M,nr,nc;
    static int rr,rc,gr,gc;
    static boolean find;
    static int cnt;
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        visited = new boolean[N][M];
        map = new int[N][M];
        
        // map으로 변환
        // R Point, G Point 찾기
        // rr rc gr gc
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                if(board[i].charAt(j)=='D')map[i][j]=1;
                else if(board[i].charAt(j)=='R') {
                    rr = i; rc =j;
                }
                else if(board[i].charAt(j)=='G'){
                    gr= i; gc=j;
                }
            }
        }
        
        // find cnt answer초기화
        find = false; cnt =0; int answer =0;
        bfs(rr,rc);
        
        if(!find) answer = -1;
        else answer = cnt;
        return answer;
    }
    
    public void bfs(int r, int c){
        q.clear();
        q.add(new int[]{r,c,0});
        visited[r][c] = true;
        
        while(!q.isEmpty()){
            int[] k = q.poll();
            
            // k[0]== gr, k[1]==gc -> return
            if(k[0]==gr && k[1]==gc) {
                find = true; cnt = k[2]; return;
            }
            
                
            out: for(int d = 0;d<4;d++){
                nr = k[0]; nc = k[1];
                while(true){
                    nr = nr+dr[d];
                    nc = nc+dc[d];
                    // nr >=0 && nr<N && nc>=0 nc<M
                    // map[nr][nc]!=1
                    if(nr < 0 || nr>=N || nc<0 ||nc>=M || map[nr][nc]==1){
                        nr = nr-dr[d];
                        nc = nc-dc[d];
                        break;
                    }
                }
                
                // 만약 방문했다면 Continue
                if(visited[nr][nc]) continue;
                
                // 방문처리 후 queue에 넣어줌
                visited[nr][nc] = true;
                q.add(new int[]{nr,nc,k[2]+1});
            }
        }
    }
}