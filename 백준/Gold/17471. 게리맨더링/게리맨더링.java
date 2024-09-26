import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] parent;
	static ArrayList<Integer> teamA;
	static ArrayList<Integer> teamB;

	static List[] connInfo;
	static int[] cntPerson;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		input();
		combi(0);
		if(min==Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

	public static void combi(int depth) {
		if (depth == N) {
			if (isValid()) {
				minDiff();
			}
			return;
		}

		// A에 넣는 경우
		teamA.add(depth + 1);
		combi(depth + 1);

		// A에 안넣는 경우
		teamA.remove(teamA.size() - 1);
		combi(depth + 1);

	}

	public static boolean isValid() {
		// 0. 팀 A size가 0이거나 N일 때
		if (teamA.size() == 0 || teamA.size() == N)
			return false;

		// 1. 팀 2개로 나누기
		divTeam();

		// 2. Union-Find
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < teamA.size() - 1; i++) {
			for (int j = i; j < teamA.size(); j++) {
				if (find(teamA.get(i)) != find(teamA.get(j))) {
					if (connInfo[teamA.get(i)].contains(teamA.get(j))) {
						union(teamA.get(i), teamA.get(j));
					}
				}
			}
		}

		for (int i = 0; i < teamB.size() - 1; i++) {
			for (int j = i; j < teamB.size(); j++) {
				if (find(teamB.get(i)) != find(teamB.get(j))) {
					if (connInfo[teamB.get(i)].contains(teamB.get(j)))
						union(teamB.get(i), teamB.get(j));
				}
			}
		}

		// 3. LinkedAll
		if (LinkedAll())
			return true;
		else
			return false;
	}

	// fin
	public static void divTeam() {
		teamB.clear();
		for (int i = 1; i <= N; i++) {
			if (!teamA.contains(i)) teamB.add(i);
		}
	}

	public static boolean LinkedAll() {
		int A = find(teamA.get(0));
		int B = find(teamB.get(0));

		for (Integer i : teamA) {
			if (A != find(i))return false;
		}

		for (Integer i : teamB) {
			if (B != find(i))return false;
		}

		return true;
	}

	// fin
	public static void minDiff() {
		int sum = 0;
		for (int i = 0; i < teamA.size(); i++) {
			sum += cntPerson[teamA.get(i)];
		}
		for (int i = 0; i < teamB.size(); i++) {
			sum -= cntPerson[teamB.get(i)];
		}

		min = Math.min(min, Math.abs(sum));
		return;
	}

	// fin
	public static int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	// fin
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	// fin
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		cntPerson = new int[N + 1];
		connInfo = new List[N + 1];
		parent = new int[N + 1];
		
		teamA = new ArrayList<>();
		teamB = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			cntPerson[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			connInfo[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				connInfo[i].add(Integer.parseInt(st.nextToken()));
			}
		}
	}
}