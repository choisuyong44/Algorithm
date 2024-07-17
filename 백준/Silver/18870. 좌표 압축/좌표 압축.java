import java.io.*;
import java.util.*;

import javax.swing.InputMap;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<n;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] rank = Arrays.copyOf(nums, nums.length);
		
		Arrays.sort(rank);
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int idx = 0;
		for(int i :rank) {
			if(!map.containsKey(i)) {
				map.put(i, idx++);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i : nums) {
			sb.append(map.get(i)+" ");
		}
		
		System.out.println(sb);
	} 
}