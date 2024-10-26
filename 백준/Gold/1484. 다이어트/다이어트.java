import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static long G;
	static long[] arr;
	static List<Integer>ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		G = sc.nextLong();
		
		ans = new ArrayList<>();
		int L =1; int R =1; 
		while(L<=100000 && R<=100000) {
			// 크기가 같은 경우
			if(R*R-L*L==G) ans.add(R);
			// R이 범위를 넘지 않고, R+L이 더 큰 경우 L을 떙겨오기
			if(R*R-L*L >= G) L++;
			else R++;
		}
		
		if(ans.isEmpty()) {
			System.out.println(-1);
			return;
		}
		Collections.sort(ans);
		for(int k : ans) {
			System.out.println(k);
		}
	}
}