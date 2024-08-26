import java.io.*;
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

	static int MAX_L;
	static int MAX_H;
	static int MAX_H_IDX;

	static int[] arr;
	static int cnt =0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// arr : SIZE N+1
		arr = new int[1001];
				
		int l =0; int h=0;
		MAX_L =0; MAX_H =0; MAX_H_IDX=0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			MAX_L = Math.max(l, MAX_L);
			
			if(h > MAX_H) {
				MAX_H = h;
				MAX_H_IDX = l;
			}
			
			arr[l] = h;
		}

		int cnt =0;
		
		// 상승
		int height =0;
		for(int i =0;i<MAX_H_IDX;i++) {
			if(height < arr[i]) {
				height = arr[i];
			}
			cnt += height;
		}	

		// 하강
		for(int i =MAX_H_IDX;i<=MAX_L;) {

			// MAX_I_IDX까지 더해주기
			for(;i<=MAX_H_IDX;i++) {
				cnt += MAX_H;
			}
			
			// 다음 MAX_H 찾기
			MAX_H = 0;
			for(int j =i;j<=MAX_L;j++) {
				if(MAX_H <=arr[j]) {
					MAX_H = arr[j];
					MAX_H_IDX =j;
				}
			}
		}
		
		System.out.println(cnt);
	}
}