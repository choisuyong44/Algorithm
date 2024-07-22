import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][2];
		
		for(int i =0;i<N;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {
			public int compare(int[] s1, int[]s2) {
				if(s1[1]==s2[1]) {
					return s1[0]-s2[0];
				}
				else {
					return s1[1]-s2[1];
				}
			}
		});

		int cnt =0; long now = 0;
		
		// 회의가 시작하자마자 끝나는 경우,
		for(int[] l : arr) {
			if(now <= l[0]) {
				cnt++;
				now = l[1];
			}
		}
		
		System.out.println(cnt);
	}

}