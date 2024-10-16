import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        System.out.println(sig(B + 1) - sig(A));
    }

    private static long sig(long n) {
        long total = 0;
        
        for(long i = 2; i < 2 * n ; i *= 2) { // i는 사이클 길이
            long one = i / 2; // 한 사이클에 있는 1 개수
            long line = n / i; // 어느 사이클까지 돌 건지 (몫)
            long remain = n % i; // 사이클이 몇 번째 자리까지 도는지
            
            total += one * line + Math.max(remain - one, 0);
        }
        
        return total;
    }
}