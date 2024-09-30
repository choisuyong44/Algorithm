import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine());
	
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(!np()) {
			System.out.println(-1);
		}
		else {
			for(int i =0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
		}
	}
	
	public static boolean np() {
		int i = N-1;
		// step 1 꼭대기 찾기
		while(i>0 && arr[i-1]>=arr[i])--i;
		if(i==0) return false;
		
		// step 2 꼭대기 앞 교환위치에 교환할 값 자리 찾ㄱ리
		int j = N-1;
		while(arr[i-1]>=arr[j])--j;
		
		// step 3 두 위치의 수 교환
		swap(i-1,j);
	
		// step 4 꼭대기 부터 맨뒤까지 오름차순 형태
		int k = N-1;
		while(i<k) swap(i++,k--);
		return true;
	}
	
	public static void swap(int i1, int i2) {
		int tmp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = tmp;
	}
}