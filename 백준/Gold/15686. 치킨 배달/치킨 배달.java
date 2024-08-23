import java.io.*;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * 
 * 1. 입력
 * 2. 부분 조합 
 * 3. 가장 가까운 치킨집 거리 - bfs 탐색
 * 4. 찾으면 stop 
 */

public class Main {
	static int[][] map;
	static int N,M;
	static int chickenCount;
	
	static boolean[] visit;
	static boolean[][] visitHouse;
	
	static List<Chicken> choice;
	static List<Chicken> chicken;
	static List<House> house;
	
	static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		choice = new ArrayList<Chicken>();
		chicken = new ArrayList<Chicken>();
		house = new ArrayList<House>();
		map = new int[N][N];
		
		int k; chickenCount=0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<N;j++) {
				k = Integer.parseInt(st.nextToken());
				
				if (k == 1) {
					house.add(new House(i,j));
					map[i][j] = 1;
				}
				
				else if(k == 2) {
					chicken.add(new Chicken(i,j));
					chickenCount++;
				}
			}
		}
		
		// dfs
		visit = new boolean[chickenCount];
		dfs(0,0);
		
		System.out.println(MIN);
	}
	
	// find subcombination
	public static void dfs(int idx,int cnt) {
		if(cnt == M) {
			cal();
		}
		
		for(int i =idx;i<chickenCount;i++) {
			if(visit[i]== false) {
				visit[i] = true;
				choice.add(chicken.get(i));
				dfs(i+1,cnt+1);
				choice.remove(chicken.get(i));
				visit[i] = false;
			}
		}
	}
	
	// find near chicken
	public static void cal () {
		int cnt = 0;
		for(House h : house) {
			int tmp = Integer.MAX_VALUE;
			for(Chicken c : choice) {
				tmp = Math.min(tmp, distance(h, c));
			}
			cnt += tmp;
		}
		MIN = Math.min(MIN, cnt);
	}
	
	public static int distance(House h, Chicken c) {
		return Math.abs(h.r-c.r)+Math.abs(h.c-c.c);
	}
	
	public static void printMap() {
		for(int r= 0 ;r<N;r++) {
			for(int c= 0;c<N;c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
	
	static class House{
		int r;
		int c;

		public House(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class Chicken{
		int r;
		int c;
		
		public Chicken(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}