import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int src,dest,dist;
        public Edge(int src,int dest, int dist) {
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }
        @Override
        public int compareTo(Edge o) {
            return dist - o.dist;
        }
        @Override
        public String toString() {
            return "Node [src=" + src + ", dest=" + dest + ", dist=" + dist + "]";
        }
    }

    static int N,M,ANS,CNT;
    static PriorityQueue<Edge> pq;
    static boolean[] visited;
    static int[] parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while(input()){
            simluation();
        }
    }

    static void simluation(){
        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(CNT==0) break;

            if(find(now.src) != find(now.dest)){
                union(now.src,now.dest);
                ANS -= now.dist;
                CNT--;
            }
        }
        System.out.println(ANS);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x>=y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<Edge>();

        // 집의 수
        N = Integer.parseInt(st.nextToken());
        // 길의 수
        M = Integer.parseInt(st.nextToken());

        // ANS
        ANS = 0;
        // 개수
        CNT = N-1;

        if (N==0 && M ==0) return false;

        visited = new boolean[N];
        parent = new int[N];

        for(int i = 0; i < N; i++){
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            pq.add(new Edge(x, y, z));

            ANS += z;
        }

        return true;
    }
}
