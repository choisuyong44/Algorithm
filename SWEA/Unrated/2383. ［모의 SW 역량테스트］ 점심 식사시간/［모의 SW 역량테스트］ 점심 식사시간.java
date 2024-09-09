import java.io.*;
import java.util.*;

public class Solution {

	static class Stair {
		int r, c, k;

		public Stair(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}

	}

	static class Person implements Comparable<Person> {
		int r, c;
		int whichStair;
		int distance;
		int down;

		public Person(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void calDiff() {
			distance = Math.abs(this.r - stair.get(whichStair).r) + Math.abs(this.c - stair.get(whichStair).c) + 1;
			down = stair.get(whichStair).k;
		}

		public void discountTime() {
			this.distance--;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			return this.distance - o.distance;
		}

		@Override
		public String toString() {
			return "Person [r=" + r + ", c=" + c + ", whichStair=" + whichStair + ", distance=" + distance + ", down="
					+ down + "]";
		}
	}

	final static int FIRST = 0;
	final static int SECOND = 1;

	static List<Person> p;
	static List<Stair> stair;

	static List<Person> p1;
	static List<Person> p2;

	static List<Person> wait1;
	static List<Person> wait2;

	static int min;
	static int time;
	static int N;
	
	static PriorityQueue<Person> pq1 = new PriorityQueue<>();
	static PriorityQueue<Person> pq2 = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			N = Integer.parseInt(br.readLine());

			stair = new ArrayList<Stair>();
			p = new ArrayList<>();

			p1 = new ArrayList<Person>();
			p2 = new ArrayList<Person>();

			wait1 = new ArrayList<Person>();
			wait2 = new ArrayList<Person>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int k = Integer.parseInt(st.nextToken());
					if (k == 1) {
						p.add(new Person(i, j));
					} else if (k > 1) {
						stair.add(new Stair(i, j, k));
					}
				}
			}
			min = Integer.MAX_VALUE;
			combi(0);

			sb.append("#").append(T).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void combi(int depth) {
		if (depth == p.size()) {

			// 거리 계산
			for (Person p : p) {
				p.calDiff();
			}

			simulation();
			min = Math.min(time, min);
			return;
		}

		// First Stair 첫 번째에서 고르는 경우
		p.get(depth).whichStair = FIRST;
		p1.add(p.get(depth));
		combi(depth + 1);

		p1.remove(p1.size() - 1);

		// Second Stair 두 번째에서 고르는 경우
		p.get(depth).whichStair = SECOND;
		p2.add(p.get(depth));
		combi(depth + 1);
		p2.remove(p2.size() - 1);
	}

	public static void simulation() {
		pq1.clear();
		pq2.clear();
		
		time = 0;
		
		for (int i = 0; i < p1.size(); i++) {
			pq1.add(p1.get(i));
		}

		for (int i = 0; i < p2.size(); i++) {
			pq2.add(p2.get(i));
		}

		while (true) {

			if (pq1.isEmpty() && pq2.isEmpty() && wait1.isEmpty() && wait2.isEmpty()) {
				return;
			}

			while (wait1.size() < 3 && !pq1.isEmpty() && pq1.peek().distance <= 0) {
				wait1.add(pq1.poll());
			}

			while (wait2.size() < 3 && !pq2.isEmpty() && pq2.peek().distance <= 0) {
				wait2.add(pq2.poll());
			}

			for (Person p : p) {
				p.discountTime();
			}

			for (int i = 0; i < wait1.size(); i++) {
				wait1.get(i).down--;
				if (wait1.get(i).down <= 0) {
					wait1.remove(i);
					i--;
				}
			}

			for (int i = 0; i < wait2.size(); i++) {
				wait2.get(i).down--;
				if (wait2.get(i).down <= 0) {
					wait2.remove(i);
					i--;
				}
			}
			
			time++;
		}
	}
}