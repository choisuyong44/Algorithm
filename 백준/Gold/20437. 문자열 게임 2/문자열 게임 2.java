import java.io.*;
import java.util.*;


public class Main {

	static String W;
	static int T,K;
	static int min, max;
	static List<Integer>[] alpha;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		for(int tc =0;tc<T;tc++) {
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
		
			min = Integer.MAX_VALUE; max = 0;
			findStringByCondi();
			
			if(max ==0) sb.append(-1).append("\n");
			else sb.append(min).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void findStringByCondi() {
		alpha = new List[26]; int k;
		for(int idx =0;idx<W.length();idx++) {
			k = W.charAt(idx)-'a';
			if(alpha[k]==null) {
				alpha[k] = new ArrayList<Integer>();
			}
			alpha[k].add(idx);
		}

		for(int i =0;i<26;i++) {
			if(alpha[i]==null) continue;
			
			int sz = alpha[i].size();
			if(sz < K) continue;
			
			for(int j=0;j<sz-K+1;j++) {
				min = Math.min(min, alpha[i].get(j+K-1) - alpha[i].get(j) + 1);
				max = Math.max(max, alpha[i].get(j+K-1) - alpha[i].get(j) + 1);
			}
		}
	}
}