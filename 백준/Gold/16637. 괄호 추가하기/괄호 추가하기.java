import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int max = Integer.MIN_VALUE;
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		String s = br.readLine();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0)
				num.add(s.charAt(i) - '0');
			else
				op.add(s.charAt(i));
		}
		int start = num.get(0);
		dfs(0, start);
		System.out.println(max);
	}

	public static void dfs(int nowIdx, int sum) {
		if (nowIdx >= op.size()) {
			max = Math.max(max, sum);
			return;
		}

		int one = cal(nowIdx, sum, num.get(nowIdx + 1));
		dfs(nowIdx + 1, one);

		if (nowIdx + 1 < op.size()) {
			int two = cal(nowIdx + 1, num.get(nowIdx + 1), num.get(nowIdx + 2));
			int res = cal(nowIdx, sum, two);
			dfs(nowIdx + 2, res);
		}
	}

	public static int cal(int op_idx, int a, int b) {
		switch (op.get(op_idx)) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		}
		return 1;
	}

}