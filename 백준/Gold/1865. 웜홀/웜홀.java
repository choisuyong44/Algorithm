import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N,M,W,S,E,T;
    static List<int[]>[] edge;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            input();
            if(hasMinusCycle())sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean hasMinusCycle() {
        Arrays.fill(dist, 0);

        for (int i = 0; i < N - 1; i++) {
            for (int now = 1; now <= N; now++) {
                for (int[] next : edge[now]) {
                    if (dist[next[0]] > dist[now] + next[1]) {
                        dist[next[0]] = dist[now] + next[1];
                    }
                }
            }
        }

        // 음수 사이클 탐지 (N번째 반복에서 값이 갱신되면 존재)
        for (int now = 1; now <= N; now++) {
            for (int[] next : edge[now]) {
                if (dist[next[0]] > dist[now] + next[1]) {
                    return true; // 음수 사이클 존재
                }
            }
        }
        return false;
    }
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        edge = new List[N+1];
        for (int i = 1; i <= N; i++) {
            edge[i] = new ArrayList<>();
        }

        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            edge[S].add(new int[]{E,T});
            edge[E].add(new int[]{S,T});
        }

        for(int i =0;i<W;i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
            edge[S].add(new int[]{E,-T});
        }
    }
}