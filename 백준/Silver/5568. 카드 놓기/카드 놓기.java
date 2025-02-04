import java.io.*;
import java.util.*;

public class Main {
    static int N,M,ans;
    static int[] card;
    static int[] choice;
    static boolean[] isContain;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        input();
        ans = 0;
        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int depth){
        if(depth ==M){
            makeNumber();
            return;
        }
        for(int i =0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                choice[depth] = i;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    static void makeNumber(){
        sb = new StringBuilder();
        for(int i =0;i<M;i++){
            sb.append(card[choice[i]]);
        }
        int num = Integer.parseInt(sb.toString());
        if(!isContain[num]){
            ans++;
            isContain[num] = true;
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        card = new int[N];
        for(int i =0;i<N;i++){
            card[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N];
        isContain = new boolean[100_000_000];
        choice = new int[M];
    }
}