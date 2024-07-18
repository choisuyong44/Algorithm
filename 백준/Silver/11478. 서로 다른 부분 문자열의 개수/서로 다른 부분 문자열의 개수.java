import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new HashMap<>();

		String s = br.readLine();

		String sub;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				sub = s.substring(i, j+1);

				if (map.get(sub) == null) {
					map.put(sub, 1);
				}	
			}
		}
		
		System.out.println(map.size());
	}
}