import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		List<Integer> score = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			score.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(score);
		
		int SZ  = score.size();
		
		for(int i =0;i<N;i++) {
			min = Math.min(min, score.get(i)+score.get(SZ-i-1));
		}
		
		System.out.println(min);
	}
}