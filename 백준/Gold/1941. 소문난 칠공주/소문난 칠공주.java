import java.io.*;
import java.util.*;

public class Main {

	static char[] map;
	static boolean[] visited;
	static int[] ans;
	static boolean[] ansCheck;
	static int ansCount;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[25];
		visited = new boolean[25];
		ans = new int[7];
		ansCount = 0;
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i * 5 + j] = s.charAt(j);
			}
		}

		combi(0, 0);
		System.out.println(ansCount);
	}

	public static void combi(int idx, int depth) {
		if (depth == 7) {
			if (!isValid())return;
			ansCount++;
			return;
		}

		for (int i = idx; i < 25; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[depth] = i;
				combi(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static boolean isValid() {
		// 1. 임도연파 갯수 확인
		int cnt = 0;
		for (int i : ans) {
			if (map[i] == 'S')
				cnt++;
		}
		if (cnt < 4) {
			return false;
		}

		// 2. 연결되었는 지 확인
		Queue<Integer> q= new LinkedList<Integer>();
		ansCheck = new boolean[7];
		q.add(ans[0]); ansCheck[0] = true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			for(int d= 0;d<4;d++) {
				int nr = k/5+dr[d];
				int nc = k%5+dc[d];
				if(nr>=0 && nr<5 && nc>=0 && nc<5) {
					for(int i =0;i<7;i++) {
						if(ans[i]/5==nr && ans[i]%5 ==nc &&!ansCheck[i]) {
							q.add(ans[i]);
							ansCheck[i]=true;
						}
					}
				}
			}
		}
		
		for(int i =0;i<7;i++) {
			if(!ansCheck[i])return false;
		}
		return true;
	}
}