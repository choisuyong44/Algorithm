import java.io.*;
import java.util.*;

public class Main {

	static int max = 0;
	static int N;
	static Egg[] eggs;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		eggs = new Egg[N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		dfs(0,0);
		
		System.out.println(max);
	}
	
	public static void dfs(int idx, int cnt) {
		
		// 끝까지 순회 || 더 이상 깰 수 있는 계란이 없다.
		if(idx == N || cnt >=N-1) {
			max =Math.max(max,cnt);
			return;
		}
		
		// 현재 계란 깨짐
		if(eggs[idx].alive==false) {
			dfs(idx+1,cnt);
			return;
		}
		
		int memoryCnt = cnt;
		for(int i=0;i<N;i++) {
			
			// 같은 계란 pass
			if(i==idx) continue;
			
			// 이미 깨진 계란 pass
			if(eggs[i].alive == false) continue;
			
			// 앞서 두개의 계란은 모두 alive 상태 확인
			cnt += hit(eggs[i],eggs[idx]);
			
			dfs(idx+1,cnt);
			
			// 계란 복원
			recovery(eggs[i], eggs[idx]);
			cnt = memoryCnt;
		}
	}
	
	public static int hit(Egg e1, Egg e2) {
		int cnt =0;
		
		e1.s -= e2.w;
		e2.s -= e1.w;
		
		if(e1.s <= 0) {
			e1.alive = false;
			cnt++;
		}
		if(e2.s <= 0) {
			e2.alive = false;
			cnt++;
		}
		
		return cnt;
	}
	
	public static void recovery(Egg e1, Egg e2) {
		e1.s += e2.w;
		e2.s += e1.w;
		
		if(e1.s > 0) e1.alive = true;
		if(e2.s > 0) e2.alive = true;
	}
	
	static class Egg{
		int s;
		int w;
		boolean alive = true;
		
		public Egg(int s, int w) {
			this.s = s;
			this.w = w;
		}
	}
}