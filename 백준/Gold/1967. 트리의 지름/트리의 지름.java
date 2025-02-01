import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<int[]>[] node;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        input();

        ans = 0;
        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            dfs(i,0);
        }

        System.out.println(ans);
    }

    static void dfs(int idx, int l){
        ans = Math.max(l,ans);
        visited[idx] = true;

        for(int[] n : node[idx]){
            if(!visited[n[0]]){
                dfs(n[0],l+n[1]);
            }
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        node = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            node[i] = new ArrayList();
        }

        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            node[p].add(new int[]{c,l});
            node[c].add(new int[]{p,l});
        }
    }
}