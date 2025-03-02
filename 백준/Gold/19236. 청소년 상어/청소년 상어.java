import java.util.*;
import java.io.*;

public class Main {
    static class Fish {
        int r, c, idx, dir;
        boolean isAlive = true;
        Fish(int r, int c, int idx, int dir, boolean isAlive) {
            this.r = r;
            this.c = c;
            this.idx = idx;
            this.dir = dir;
            this.isAlive = isAlive;
        }
    }

    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
    static int answer;
    public static void main(String[] args) throws Exception{
        Fish[] fishes = new Fish[17];
        int[][] map = new int[4][4];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int idx = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                fishes[idx] = new Fish(i, j, idx, dir-1, true);
                map[i][j] = idx;
            }
        }

        dfs(0, 0, 0, 0, fishes, map); //상어가 이동하는 좌표, 방향, 먹은 물고기 합

        System.out.println(answer);
    }

    public static void dfs(int r, int c, int dir, int sum, Fish[] fishes, int[][] map){
        sum += map[r][c];
        dir = fishes[map[r][c]].dir;
        fishes[map[r][c]].isAlive = false;

        answer = Math.max(answer, sum);

        //물고기 이동
        for(int f=1; f<=16; f++){
            if(fishes[f].isAlive){
                move_fish(r, c, fishes[f], fishes, map);
            }
        }

        //상어 이동
        for(int i=1; i<=3; i++){
            int nr = r + dr[dir]*i;
            int nc = c + dc[dir]*i;

            //범위를 초과했거나 물고기가 없는 칸
            if(nr<0 || nc<0 || nr>=4 || nc>=4 || !fishes[map[nr][nc]].isAlive) continue;

            //fishes, map 복제
            Fish[] tempFish = new Fish[17];
            for(int f=1; f<=16; f++){
                Fish fish = fishes[f];
                tempFish[f] = new Fish(fish.r, fish.c, fish.idx, fish.dir, fish.isAlive);
            }

            int[][] tempMap = new int[4][4];
            for(int t=0; t<4; t++){
                tempMap[t] = map[t].clone();
            }

            dfs(nr, nc, dir, sum, fishes, map);

            fishes = tempFish;
            map = tempMap;

        }
    }

    public static void move_fish(int r, int c, Fish fish, Fish[] fishes, int[][] map){
        for(int i=0; i<8; i++){
            int nr = fish.r + dr[fish.dir];
            int nc = fish.c + dc[fish.dir];

            //범위를 초과했거나 상어가 있는 칸
            if(nr<0 || nc<0 || nr>=4 || nc>=4 || (nr==r && nc==c)) {
                fish.dir = (fish.dir+1)%8;
                continue;
            }

            //위치를 바꿈
            Fish target = fishes[map[nr][nc]];
            map[fish.r][fish.c] = target.idx;
            map[nr][nc] = fish.idx;       
            target.r = fish.r; target.c = fish.c; 
            fish.r = nr; fish.c = nc; 
            break;
        }
    }
}