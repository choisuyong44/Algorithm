import java.io.*;
import java.util.*;

class Solution {
    static int r1,r2,c1,c2,nr,nc,r,c;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int N, M, SZ;
    static int[][] map;
    static int[] answer;
    static int[][] q;
    public int[] solution(int rows, int columns, int[][] queries) {
        N = rows; 
        M = columns; 
        SZ = queries.length;
        map = new int[N+1][M+1];
        answer = new int[SZ];
        q = queries;
        
        int cnt = 1;
        for(int i = 1;i<N+1;i++){
            for(int j =1;j<M+1;j++){
                map[i][j] = cnt++;
            }
        }
        
        for(int i =0;i<SZ;i++){
            answer[i] = circuit(i);
        }
        
        return answer;
    }
    
    static int circuit(int idx){
        int d = 0; int min = Integer.MAX_VALUE;
        
        r1 = q[idx][0]; c1 = q[idx][1];
        r2 = q[idx][2]; c2 = q[idx][3];
        
        // 원래 배열 값 저장
        int origin = map[r1][c1];
        min = Math.min(min,origin);
        
        // 회전 & 최솟값 갱신
        r = r1; c = c1;             // r,c 초기화
        nr = r+dr[d]; nc = c+dc[d]; // nr,nc 값 초기화
        
        map[r][c] = map[nr][nc];
        min = Math.min (min, map[r][c]);
        
        r = nr; c = nc;
        while(true){
            nr = r+dr[d]; nc = c+dc[d];
            
            if(nr == r1 && nc == c1) {
                map[r][c] = map[nr][nc];
                map[r][c] = origin;
                min = Math.min(min,map[nr][nc]);
                break;
            }
            
            // 범위 내에 있는 지 체크
            if(nr < r1 || nc < c1 || nr > r2 || nc > c2){
                d++;
                continue;
            }
            
            map[r][c] = map[nr][nc];
            r = nr; c = nc; // 갱신
            min = Math.min(min,map[r][c]);
        
        }
        return min;
    }
}