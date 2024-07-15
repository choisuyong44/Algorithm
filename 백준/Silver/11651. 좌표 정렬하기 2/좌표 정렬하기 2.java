import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int[][] arr = new int[T][2];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,(v1,v2)->{
			if(v1[1] == v2[1]) {
				return v1[0] - v2[0];
			}
			return v1[1] - v2[1];
		});
		
		for(int i =0;i<T;i++) {
			System.out.println(arr[i][0]+ " "+arr[i][1]);
		}
	}
}