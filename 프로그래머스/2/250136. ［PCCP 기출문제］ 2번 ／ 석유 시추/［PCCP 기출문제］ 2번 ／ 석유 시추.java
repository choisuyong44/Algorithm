import java.io.*;
import java.util.*;

class Solution {
    static int N,M;
    static boolean[][] visited;
    static List<int[]> list;
    static Queue<int[]> q = new LinkedList<>();
    static int gcount,sum;
    static boolean[] visitedGroup;
    static int[][][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        int answer = 0;
        
        map = new int[N][M][2];
        visited = new boolean[N][M];
        list = new ArrayList<>();
        sum =0;gcount =0;
        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j] && land[i][j]==1){
                    bfs(land,i,j);
                    sum =0; gcount++;
                }
            }
        }

        for(int c =0;c<M;c++){
            visitedGroup = new boolean[gcount];
            int cnt =0;
            for(int r = 0;r<N;r++){
                if(!visitedGroup[map[r][c][0]] && land[r][c]==1){
                    visitedGroup[map[r][c][0]]=true;
                    cnt+= map[r][c][1];
                }
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
    
    public void bfs(int[][] land, int r, int c){
        list.clear(); q.clear();
        sum++;
        visited[r][c] = true; 
        q.add(new int[]{r,c});
        list.add(new int[]{r,c});
        
        while(!q.isEmpty()){
            int[] k = q.poll();
            for(int d = 0;d<4;d++){
                int nr = k[0]+dr[d];
                int nc = k[1]+dc[d];
                if(nr>=0 && nr< N && nc>=0 && nc<M){
                    if(!visited[nr][nc] && land[nr][nc]==1){
                        visited[nr][nc] = true;
                        q.add(new int[]{nr,nc});
                        list.add(new int[]{nr,nc});
                        sum++;
                    }
                }
            }
        }
        
        for(int i=0;i<list.size();i++){
            int[] tmp = list.get(i);
            map[tmp[0]][tmp[1]][0] = gcount;
            map[tmp[0]][tmp[1]][1] = sum;
        }
    }
    
    public void printMap(){
        for(int i =0;i<N;i++){
            for(int j =0;j<M;j++){
                System.out.print(map[i][j][1] + " ");
            }
        }
    }
}