import java.io.*;
import java.util.*;

public class Solution {

	static int max;
	static int cnt;
	static String s;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T < TC + 1; T++) {
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();

			arr = new int[s.length()];

			for (int i = 0; i < s.length(); i++) {
				arr[i] = s.charAt(i) - '0';
			}

			cnt = Integer.parseInt(st.nextToken());

			// 최적화 -> 각 자리마다 하나씩 배치
			// s.length()번 이면 충분함
			if (cnt > s.length())
				cnt = s.length();
			
			max =0;
			
			combi(0,0);
			
			sb.append("#").append(T).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static void combi(int idx,int depth) {
		if (depth == cnt) {
			int ans =0; int digit =1;
			
			for(int i=s.length()-1;i>=0;i--) {
				ans += digit*arr[i];
				digit *= 10;
			}
			max = Math.max(ans, max);
			
			return;
		}

		for (int i = idx; i < s.length()-1; i++) {
			for (int j = i+1 ; j < s.length(); j++) {
				swap(i,j);
				combi(i,depth+1);
				swap(i,j);
			}
		}
	}

	static void swap(int v1, int v2) {
		int tmp = arr[v1];
		arr[v1] = arr[v2];
		arr[v2] = tmp;
	}
}