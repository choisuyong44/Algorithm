import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String,Integer> map1 = new HashMap<>();
		Map<Integer,String> map2 = new HashMap<>();
		
		for(int i =1;i<N+1;i++) {
			String k = br.readLine();
			map1.put(k,i);
			map2.put(i,k);
		}

		for(int i = 0;i<M;i++) {
			String t = br.readLine();
			if(t.charAt(0)>='A' && t.charAt(0)<='Z') {
				System.out.println(map1.get(t));
			}
			else {
				System.out.println(map2.get(Integer.parseInt(t)));
			}
		}
	}
}