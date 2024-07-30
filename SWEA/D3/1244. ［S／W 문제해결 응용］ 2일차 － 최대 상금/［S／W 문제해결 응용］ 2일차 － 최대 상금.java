import java.io.*;
import java.util.*;


public class Solution {

	static int[] num;
	static int max;
	static int switchCnt;
	static StringBuilder sb = new StringBuilder();
	
	public static void swap(int i1,int i2) {
		int tmp = num[i1];
		num[i1] = num[i2];
		num[i2] = tmp;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		String s;
		
		for(int t =1;t<T+1;t++) {

			// 입력
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
			num = new int[s.length()];
			
			for(int i =0;i<s.length();i++) {
				num[i] = s.charAt(i)-'0';
			}
			
			switchCnt = Integer.parseInt(st.nextToken());
			
			// 문자열 횟수만 교환이 일어나면 되므로, 나머지는 불필요한 교환 
			if(switchCnt > s.length()) {
				switchCnt  = s.length();
			}
			
			max =0;
			
			dfs(0,0,s.length());
			
			sb.append("#").append(t).append(" "+ max+"\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int idx,int cnt,int len) {
		if(cnt == switchCnt) {
			String s = "";
			for(int i : num) {
				s+=Integer.toString(i);
			}
			
			max = Math.max(max,Integer.parseInt(s));
			return;
		}
		
		for(int i = idx;i<len-1;i++) {
			for(int j = i+1;j<len;j++) {
				swap(i,j);
				dfs(i,cnt+1,len);
				swap(i,j);
			}
		}
	}
}