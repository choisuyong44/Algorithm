import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] num;
	static int[][] adjArr;
	static int[] degree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC = 10;
		int V,E;
	
		for(int T = 1;T<TC+1;T++) {
			sb.append("#").append(T).append(" ");
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			num = new int[V+1];
			for(int i =1;i<=V;i++) {
				num[i] = i;
			}
			
			adjArr = new int[V+1][V+1];
			degree = new int[V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				adjArr[A][B] = 1;
				degree[B]++;
			}
			
			// 위상정렬 1장 queue에 진입차수가 0인 친구들을 모두 넣어라
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i = V;i>=1;i--) {
				if(degree[i]==0) {
					q.add(i);
				}
			}
			
			// 위상정렬 2장
			// 간선을 제거하고, 진입 차수가 0이 되면 새롭게 큐에 넣는다.
			while(!q.isEmpty()) {
				int curr = q.poll();
				sb.append(num[curr]).append(" ");
				
				for(int i = 1;i<V+1;i++) {
					// 유향 그래프, 연결되어있음을 나타냄
					if(adjArr[curr][i]==1) {
						degree[i]--;		// 진입 차수 하나 깎아
						adjArr[curr][i] = 0;// 연결 해제
						
						// 만약 이번에 i 정점의 진입차수가 0이 되었다면
						if(degree[i]==0) {
							q.add(i);
						}
					}
				}
			}
			sb.append("\n");
		}
		// 밑에서 한방에 출력을 하고 싶다.
		System.out.println(sb.toString());
	}
}