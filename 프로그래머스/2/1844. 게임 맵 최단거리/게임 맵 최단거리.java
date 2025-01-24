import java.io.*;
import java.util.*;

class Solution {
    static int N, M,nr,nc;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static class Move {
        int r,c,w;
        Move(int r, int c, int w){
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }
    static Queue<Move> q = new LinkedList();
    public int solution(int[][] maps) {
        map = maps;
        N = maps.length;
        M = maps[0].length;
        int answer = bfs();
        return answer;
    }
    
    static int bfs(){
        visited = new boolean[N][M];
        q.add(new Move(0,0,1));
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            Move m = q.poll();
            if(m.r==N-1 && m.c==M-1) return m.w;
            
            for(int d =0;d<4;d++){
                nr = m.r+dr[d];
                nc = m.c+dc[d];
                
                if(nr<0 || nr>= N || nc<0 || nc>=M || map[nr][nc]==0) continue;
                
                if(!visited[nr][nc]){
                    q.add(new Move(nr,nc,m.w+1));
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }
}