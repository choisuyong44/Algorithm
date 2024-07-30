import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(bf.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int min = 0;
        int max = -1;
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(bf.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {
                max = arr[i];
            }
        }
                
        
        while(min <= max) {
            long sum = 0;
            int mid = (max + min) / 2;
            for(int i = 0; i < N; i++) {
                if(arr[i] >= mid) {
                    sum += (arr[i]-mid);
                }
            }
            if(sum >= M) {
                min = mid + 1;
            }
            else if(sum < M) {
                max = mid - 1;
            }
            
        }
        
        System.out.println(max);
    }
}