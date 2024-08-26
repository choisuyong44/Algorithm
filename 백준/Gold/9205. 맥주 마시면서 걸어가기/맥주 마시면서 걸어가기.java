import java.io.*;
import java.util.*;

public class Main {
	
	static Queue<Pos> q = new LinkedList<>();

	static boolean canArrive;
	static Pos src;
	static Pos[] dest;
	static boolean[] visit;
	
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int TC= Integer.parseInt(br.readLine());
		
		for(int T = 1; T< TC+1;T++) {
			q.clear();
			canArrive = false;
			
			// 주유소 개수 받기
			N = Integer.parseInt(br.readLine());
					
			// 출발지 입력 
			st = new StringTokenizer(br.readLine());
			src = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),false);
			
			// 주유소 입력 + 도착지 입력
			dest = new Pos[N+1];
			visit = new boolean[N+1]; int i;
			for(i =0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				dest[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),false);
			}
			st = new StringTokenizer(br.readLine());
			dest[i] = new Pos(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),true);
			
			// 탐색
			bfs(src);
			
			if(canArrive == true) {
				sb.append("happy").append("\n");
			}
			else {
				sb.append("sad").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(Pos src) {
		q.add(src);
		
		while(!q.isEmpty()) {
			
			Pos p = q.poll();
			
			// 도착 좌표
			if(canArrive == true || p.dest == true) {
				canArrive = true;
				return;
			}
			
			for(int i=0;i<dest.length;i++) {
				if(visit[i] == false && possible(p,dest[i]) == true ) {
					visit[i] = true;
					q.add(dest[i]);
				}
			}
		}
	}
	
	public static boolean possible (Pos src,Pos dest) {
		
		if(Math.abs(src.r-dest.r) + Math.abs(src.c-dest.c) <= 1000) {
			return true;
		}
		
		return false;
	}
	
	static class Pos{
		int r;
		int c;
		boolean dest;
		
		public Pos(int r, int c,boolean dest) {
			this.r = r;
			this.c = c;
			this.dest = dest;
		}
	}
}