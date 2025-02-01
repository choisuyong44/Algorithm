import java.io.*;
import java.util.*;

class Solution {
    static int N,M,nr,nc,mid,end,answer;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visited;
    static int[] S = new int[3];
    static int[] E = new int[3];
    static int[] L = new int[3];
    static Queue<int[]> q = new LinkedList();
    static String[] inputData;
    public int solution(String[] maps) {
        // 0. init
        inputData = maps;
        input();
        answer =0;  
        // 1. 레버까지 최단 거리 : mid
        if(!findDest(S,L)) return -1;
        // 2. 레버부터 출구까지 최단 거리 : end
        if(!findDest(L,E)) return -1;
        return answer;
    }
    
    static boolean findDest(int[] src, int[] dest){
        q.clear();
        q.add(src);
        visited = new boolean[N][M]; 
        visited[src[0]][src[1]] = true;
        while(!q.isEmpty()){
            int[] k = q.poll();
            if(k[0]==dest[0] && k[1]==dest[1]){
                answer += k[2];
                return true;
            }
            for(int d =0 ;d<4;d++){
                nr = k[0]+dr[d];
                nc = k[1]+dc[d];
                if(nr < 0 || nr >=N || nc<0 || nc>=M 
                   || map[nr][nc] == 'X' || visited[nr][nc]) continue;
                q.add(new int[]{nr,nc,k[2]+1});
                visited[nr][nc] = true;
            }
        }
        return false;
    }
    
    static void input(){
        N = inputData.length;
        M = inputData[0].length();
        map = new char[N][M];
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                if(inputData[i].charAt(j)=='S'){
                    S[0] = i; S[1] =j;
                }
                else if(inputData[i].charAt(j)=='E'){
                    E[0] = i; E[1] =j;
                }
                else if(inputData[i].charAt(j)=='L'){
                    L[0] = i; L[1] =j;
                }
                map[i][j] = inputData[i].charAt(j);
            }
        }
    }
}