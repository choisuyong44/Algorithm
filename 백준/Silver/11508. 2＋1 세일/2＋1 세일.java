import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<Integer>();
		
		
		for(int i =0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list, Collections.reverseOrder());

		int sum =0;
		
		for(int i =0;i<N;i++) {
			if(i%3==2)continue;
			sum += list.get(i);
		}
		
		System.out.println(sum);
	}
}