import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new TreeMap<>();
		
		String pass; String extenstion; int v;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine(),".");
			pass = st.nextToken();
			extenstion = st.nextToken();
			
			if(map.containsKey(extenstion)) {
				v = map.get(extenstion);
				map.put(extenstion, ++v);
			}
			
			else {
				map.put(extenstion, 1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : map.keySet()) {
			// System.out.printf("%s %d\n",s,map.get(s));
			sb.append(s + " " + map.get(s)+"\n");
		}
		
		System.out.println(sb);
	}
}