import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<String,String> map = new HashMap<String, String>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String p = st.nextToken();
			String entry = st.nextToken();
			
			if (entry.equals("enter")) {
				map.put(p,entry);
			}
			else {
				map.remove(p);
			}
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());
		
		keySet.sort((s1,s2)->s2.compareTo(s1));
		
		for(String i :keySet) {
			System.out.println(i);
		}
	}
}