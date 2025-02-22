import java.util.*;

class Solution {
    static class Link implements Comparable<Link> {
        int dest;
        int cost;
        
        public Link(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Link O){
            return this.cost - O.cost;
        }
    }

    static int[] dist;
    static List<Link>[] node;
    static boolean[] visited;
    static PriorityQueue<Link> pq = new PriorityQueue<>();
    public int solution(int N, int[][] road, int K) {
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist,2_000_000_000);
        
        node = new List[N+1];
        for(int i =0 ;i<N+1;i++){
            node[i] = new ArrayList();
        }
        
        for(int i=0;i<road.length;i++){
            node[road[i][0]].add(new Link(road[i][1], road[i][2]));
            node[road[i][1]].add(new Link(road[i][0], road[i][2]));
        }
        
        djikstra();
        int answer = count(N,K);
        return answer;
    }
    
    static void djikstra(){
        pq.add(new Link(1,0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Link now = pq.poll();
            
            if(visited[now.dest]) continue;
            visited[now.dest] = true;
            
            for(Link next : node[now.dest]){
                if(dist[next.dest] > dist[now.dest] + next.cost){
                    dist[next.dest] = dist[now.dest] + next.cost;
                    pq.add(new Link(next.dest, dist[next.dest]));
                }
            }
        }
    }
    
    static int count(int N,int K){
        int cnt =0;
        for(int i=1;i<N+1;i++){ 
            if(dist[i] <=K) {
                cnt++;
            }
        }
        return cnt;
    }
}