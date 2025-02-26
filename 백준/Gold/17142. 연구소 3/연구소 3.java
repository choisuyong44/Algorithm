import java.io.*;
import java.util.*;

public class Main {
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int N,M,nr,nc,virusSize,ans, possibleCnt;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> virusList,choiceList;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        if(ans==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void simulation(){
        q = new LinkedList<>();
        visited = new boolean[N][N];

        for(int i = 0; i < M; i++){
            q.add(new int[]{choiceList.get(i)[0],choiceList.get(i)[1]});
            visited[choiceList.get(i)[0]][choiceList.get(i)[1]] = true;
        }

        int time = -1;
        int SZ;
        int V_SZ = virusSize;

        while(!q.isEmpty()){
            time++;
            if(time > ans) return;
            if(V_SZ == possibleCnt) {
                ans = Math.min(time, ans);
                return;
            }

            SZ = q.size();
            for(int sz =0 ;sz<SZ;sz++){
                int[] k = q.poll();
                for(int d =0;d<4;d++){
                    nr = k[0]+dr[d];
                    nc = k[1]+dc[d];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(!visited[nr][nc] && map[nr][nc] != 1) {
                        q.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                        if(map[nr][nc]!=2)V_SZ++;
                    }
                }
            }
        }
    }

    // N개 중에 중복 포함 M개 선택
    static void dfs(int idx){
        if (choiceList.size()==M){
            simulation();
            return;
        }

        for(int i = idx;i < virusSize;i++){
            choiceList.add(virusList.get(i));
            dfs(i+1);
            choiceList.remove(virusList.get(i));
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MAX_VALUE;

        map = new int[N][N];
        choiceList = new ArrayList<>();
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virusList.add(new int[]{i,j});
                if(map[i][j] != 1) possibleCnt++;
            }
        }

        virusSize = virusList.size();
    }
}